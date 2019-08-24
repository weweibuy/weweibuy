package com.weweibuy.webuy.learning.spring.thead;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author durenhao
 * @date 2019/8/24 17:30
 **/
@Slf4j
public class FutureTest {


    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void test01() throws Exception{
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            log.info("run async");
        }, executorService);
        Thread.sleep(200);
    }

    @Test
    public void test02() throws Exception{
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            log.info("run async");
            return "async result";
        }, executorService);

        completableFuture.whenComplete((i, e) -> {
            log.info("计算完成回调: {}", i);
        });

        completableFuture.whenCompleteAsync((i, e) -> {
            log.info("计算完成异步回调: {}", i);
        }, executorService);

        Thread.sleep(200);
    }


    @Test
    public void test03() throws Exception{
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            log.info("run async");
            return "async result";
        }, executorService);

        CompletableFuture<String> stringCompletableFuture = completableFuture.thenApply(i -> {
            log.info("第一个计算完成结果1: {}", i);
            return i + "追加结果1";
        });

        CompletableFuture<String> stringCompletableFuture1 = completableFuture.thenApply(i -> {
            log.info("第一个计算完成结果2: {}", i);
            return i + "追加结果2";
        });

        String s = completableFuture.get();
        String s1 = stringCompletableFuture1.get();
        log.info("最终结果: {}", s1 );
    }

}
