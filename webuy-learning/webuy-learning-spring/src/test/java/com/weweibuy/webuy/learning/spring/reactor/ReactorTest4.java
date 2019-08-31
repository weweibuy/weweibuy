package com.weweibuy.webuy.learning.spring.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

import java.util.stream.Stream;

/**
 * @author durenhao
 * @date 2019/8/27 22:57
 **/
@Slf4j
public class ReactorTest4 {

    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    {
        threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("reactor-test-");
        threadPoolTaskExecutor.setCorePoolSize(3);
        threadPoolTaskExecutor.setMaxPoolSize(3);
        threadPoolTaskExecutor.initialize();
    }


    @Test
    public void test01() throws InterruptedException {
        EmitterProcessor<Integer> processor = EmitterProcessor.create();
        FluxSink<Integer> sink = processor.sink(FluxSink.OverflowStrategy.BUFFER);

        processor
                .doOnComplete(() -> {
                    log.info("1号完成: {}");
                })
                .subscribe(i -> {
                    log.info("1号订阅数据: {}", i);
                });

        processor
                .filter(i -> i > 50)
                .window(60, 60)
                .flatMap(i -> i.collectList())
                .subscribeOn(Schedulers.fromExecutor(threadPoolTaskExecutor))
                .doOnComplete(() -> {
                    log.info("2号订完成");
                });

        Stream.iterate(0, i -> i + 1)
                .limit(100)
                .forEach(i -> {
                    sink.next(i);
                });
        sink.complete();
        Thread.sleep(100);

    }


    @Test
    public void test02() throws InterruptedException {
        DirectProcessor<Integer> processor = DirectProcessor.create();
        FluxSink<Integer> sink = processor.sink(FluxSink.OverflowStrategy.BUFFER);
        processor
                .doOnComplete(() -> {
                    log.info("1号完成: {}");
                })
                .subscribe(i -> {
                    log.info("1号订阅数据: {}", i);
                });

        processor
                .filter(i -> i > 50)
                .window(60, 60)
                .flatMap(i -> i.collectList())
                .publishOn(Schedulers.fromExecutor(threadPoolTaskExecutor))
                .doOnComplete(() -> {
                    log.info("2号订完成");
                })
                .subscribe(i -> {
                    log.info("2号订阅数据: {}", i);
                });


        Stream.iterate(0, i -> i + 1)
                .limit(100)
                .forEach(i -> {
                    sink.next(i);
                });
        sink.complete();
        Thread.sleep(100);

    }


}
