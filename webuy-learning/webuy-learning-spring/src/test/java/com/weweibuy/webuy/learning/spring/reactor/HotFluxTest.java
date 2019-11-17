package com.weweibuy.webuy.learning.spring.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;

/**
 * @author durenhao
 * @date 2019/11/15 22:57
 **/
@Slf4j
public class HotFluxTest {

    private ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    {
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setThreadNamePrefix("reactor-flux-test-");
        executor.initialize();
    }

    @Test
    public void test01() throws InterruptedException {

        UnicastProcessor<String> hotSource = UnicastProcessor.create();

        Flux<List<String>> stringFlux = hotSource.publish()
                .autoConnect()
                .doOnNext(n -> log.info("事件: {}", n))
                .bufferTimeout(500, Duration.ofMillis(2000), Schedulers.single());

        stringFlux.subscribe(d -> log.error("Subscriber 1 to Hot Source: " + d));

        hotSource.onNext("blue");
        hotSource.onNext("green");

        hotSource.onNext("TEST");



        stringFlux.subscribe(d -> log.info("Subscriber 2 to Hot Source: " + d));

        hotSource.onNext("orange");
        hotSource.onNext("purple");

        Thread.sleep(3000);
    }


}
