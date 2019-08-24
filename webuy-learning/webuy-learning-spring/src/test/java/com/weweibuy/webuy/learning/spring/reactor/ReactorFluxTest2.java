package com.weweibuy.webuy.learning.spring.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author durenhao
 * @date 2019/8/9 22:52
 **/
@Slf4j
public class ReactorFluxTest2 {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    private ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    {
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setThreadNamePrefix("reactor-flux-test-");
        executor.initialize();
    }


    @Test
    public void test01() throws Exception {
        List<Integer> collect = Stream.iterate(0, i -> i + 1)
                .limit(100)
                .collect(Collectors.toList());

        String s = "";

        String block = Flux.fromStream(collect.stream())
                .window(10, 10)
                .flatMap(i -> i.collectList())
                .parallel(4)
                .runOn(Schedulers.elastic())
                .map(i -> {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("转String: {}", i);
                    return i + "";
                })
                .map(i -> {
                    return i + " hello ";
                })
                .sequential()
                .doOnTerminate(() -> {
                    log.info("doOnTerminate ..");
                })
                .reduce(s, (a, b) -> {
                    log.info("聚合");
                    return a + b;
                })
                .block();
        log.error("完成 : {}; 结果: {}", block, s);
    }


    @Test
    public void test02() {
        Flux.generate(
                AtomicLong::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next("3 x " + i + " = " + 3 * i);
                    if (i == 10) sink.complete();
                    return state;
                }, (state) -> System.err.println("state: " + state))
                .subscribe();
    }


    @Test
    public void test03() throws InterruptedException {
        Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) sink.complete();
                    return state + 1;
                })
                .parallel(3)
                .runOn(Schedulers.fromExecutor(executor))
                .doOnNext(i -> {
                    log.info("doOnNext : {}", i);
                })
                .sequential()
                .doOnComplete(() -> {
                    log.info("doOnComplete");
                })
                .subscribe(i -> {
                    log.info("subscribe  {}", i);
                });
        Thread.sleep(20);
    }

    @Test
    public void test04() throws InterruptedException {

        List<Integer> collect = Stream.iterate(0, i -> i + 1)
                .limit(100)
                .collect(Collectors.toList());

        Mono<Flux<Integer>> fluxMono = Mono.fromCallable(() -> {
            return Flux.fromStream(collect.stream());
        });
        fluxMono.subscribeOn(Schedulers.fromExecutor(executor))
                .subscribe(i -> {
                    i.subscribe(k -> {
                        log.info("值: {}", k);
                    });
                });
        Thread.sleep(1000);
    }


    @Test
    public void test05() {
        List<Integer> collect = Stream.iterate(0, i -> i + 1)
                .limit(100)
                .collect(Collectors.toList());

    }


}
