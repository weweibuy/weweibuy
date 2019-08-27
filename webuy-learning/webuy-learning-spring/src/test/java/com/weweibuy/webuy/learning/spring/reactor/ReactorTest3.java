package com.weweibuy.webuy.learning.spring.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author durenhao
 * @date 2019/8/24 19:09
 **/
@Slf4j
public class ReactorTest3 {

    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    @Test
    public void test01() throws Exception {

        Mono.fromDirect(
                Mono.just("hello")
                        .doOnSuccess(i -> {
                            log.info("处理成功: {}", i);
                        })
                        .then(
                                Mono.zip(Mono.just("world "), Mono.just("你好"))
                                        .doOnNext(i -> {
                                            log.info("内部on next: {}", i);
                                        })

                        )
        )
                .subscribe(i -> {
                    log.info("订阅: {}", i);
                });
    }


    @Test
    public void test02() throws Exception {
        Flux.from(
                Flux.range(0, 10)
                        .publishOn(Schedulers.fromExecutor(executorService))
                        .doOnNext(i -> {
                            log.info("内部 on text : {}", i);
                        })
        )
                .map(i -> {
                    return i * 10;
                })
                .doOnNext(i -> {
                    log.info("最外层 on text : {}", i);
                }).subscribe();
        Thread.sleep(200);
    }


    @Test
    public void test03() throws Exception {
        Mono<String> just = Mono.just("初始化SDK")
                .subscribeOn(Schedulers.newSingle("init-sdk-"))
                .doOnNext(i -> {
                    log.info("准备: {}", i);
                });
        Mono<String> just1 = Mono.just("初始化数据库")
                .subscribeOn(Schedulers.newSingle("init-ds-"))
                .doOnNext(i -> {
                    log.info("准备: {}", i);
                });
        Mono<String> just2 = Mono.just("初始化页面")
                .subscribeOn(Schedulers.newSingle("init-page-"))
                .doOnNext(i -> {
                    log.info("准备: {}", i);
                });
        Flux.merge(just, just1, just2)
                .subscribe(i -> {
                    log.info("订阅数据: {}", i);
                });
        Thread.sleep(200);
    }


    @Test
    public void test04() throws Exception {
        Flux.range(0, 10)
                .timeout(Duration.ofMillis(800))

                .map(i -> {
                    if (true) {
                        throw new RuntimeException("转化数据异常");
                    }
                    return i * 10;
                })
                .onErrorResume(e -> {
                    log.error("发生错误: ", e);
                    return Flux.just(9999);
                })
                .switchIfEmpty(i -> {
                    i.onNext(0000);
                })
                .take(5)
                .publishOn(Schedulers.fromExecutor(executorService))
                .subscribe(i -> {
                    log.info("展示数据: {}", i);
                }, e -> {
                    log.info("订阅发生错误: {}", e);
                });
        Thread.sleep(200);
        log.info("完成");
    }


    @Test
    public void test05() throws Exception {
        Flux<String> ids = Flux.just("101", "102", "103", "104", "105");

        Flux<String> combinations =
                ids
                        .flatMap(id -> {
                    Mono<String> nameTask = Mono.just("tom " + id);
                    Mono<Integer> statTask = Mono.just(Integer.valueOf(id));
                    log.info("flatMap: {}", id);
                    return nameTask.zipWith(statTask,
                            (name, stat) -> "Name " + name + " has stats " + stat);
                });

        Mono<List<String>> result = combinations.collectList();

        List<String> results = result.block();
        log.info("结果: {}", results);
    }


    @Test
    public void test06() throws Exception{
        Flux<Integer> integerFlux = Flux.range(0, 10)
                .publishOn(Schedulers.fromExecutor(executorService));
    }

}
