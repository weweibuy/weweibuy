package com.weweibuy.webuy.learning.spring.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import reactor.core.publisher.Flux;
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

        Flux.fromStream(collect.stream())
                .window(10, 10)
                .flatMap(i -> i.collectList())
                .parallel(3)
                .runOn(Schedulers.fromExecutor(executor))
                .map(i -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("转String: {}", i);
                    return i + "";
                })
                .map(i -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("拼接: {}", i);
                    return i + " hello ";
                })
                .doOnNext(i -> {
                    log.info("doOnNext: {}", i);
                })
                .sequential()
                .reduce(s, (a, b) -> {
                    log.info("聚合");
                    return a + b;
                })
                .doOnSuccess(i -> {
                    log.info("success : {}", i);
                })
                .subscribe();
        Thread.sleep(5000);
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
                    sink.next("3 x " + state + " = " + 3*state);
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
                .subscribe( i -> {
                    log.info("subscribe  {}", i);
                });
        Thread.sleep(20);
    }

}
