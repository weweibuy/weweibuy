package com.weweibuy.webuy.learning.spring.thead;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author durenhao
 * @date 2019/8/24 17:30
 **/
@Slf4j
public class FutureTest {


    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void test01() throws Exception {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            log.info("run async");
        }, executorService);
        Thread.sleep(200);
    }

    @Test
    public void test02() throws Exception {
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
    public void test03() throws Exception {
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
        log.info("最终结果: {}", s1);
    }


    @Test
    public void test04() throws Exception{
        CompletableFuture<List<String>> ids = CompletableFuture.supplyAsync(() -> {
            List<String> list = new ArrayList<>();
            list.add("101");
            list.add("102");
            list.add("103");
            list.add("104");
            list.add("105");
            log.info("组装数据");
            return list;
        });

        CompletableFuture<List<String>> result = ids.thenComposeAsync(l -> {
            Stream<CompletableFuture<String>> zip =
                    l.stream().map(i -> {
                        CompletableFuture<String> nameTask = CompletableFuture.supplyAsync(() -> {
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            log.info("获取名字: {}", i);
                           return  "tom " + i;
                        });
                        CompletableFuture<Integer> statTask =  CompletableFuture.supplyAsync(() -> {
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            log.info("获取状态: {}", i);
                            return Integer.valueOf(i);
                        });
                        return nameTask.thenCombineAsync(statTask, (name, stat) -> "Name " + name + " has stats " + stat);
                    });
            List<CompletableFuture<String>> combinationList = zip.collect(Collectors.toList());

            CompletableFuture<String>[] combinationArray = combinationList.toArray(new CompletableFuture[combinationList.size()]);

            CompletableFuture<Void> allDone = CompletableFuture.allOf(combinationArray);
            return allDone.thenApply(v -> combinationList.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList()));
        });
        log.info("等待结果");
        List<String> results = result.join();
        log.info("结果: {}", results);
    }


}
