package com.weweibuy.webuy.learning.spring.thead;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;
import java.util.stream.Stream;

@Slf4j
public class ThreadPoolHolderTest {

    private ThreadPoolTaskExecutor taskExecutor;

    private ExecutorService threadPoolExecutor;

    {
        taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(3);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setThreadNamePrefix("spring-async-");
        taskExecutor.setQueueCapacity(100);
        taskExecutor.initialize();
        threadPoolExecutor = new ThreadPoolExecutor(3, 10, 60L,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(100), new CustomizableThreadFactory("jdk-async-"));
    }


    /**
     * 线程池提交任务执行流程
     * 新建线程池
     * 提交任务到线程池  --> 核心池 < 配置数  --> 创建线程
     * 核心池满了(核心池 = 配置数)  -->  任务放入队列
     * 队列满了  --> 创建线程执行( maxPoolSize)
     * maxPoolSize 数量满了  --> 拒绝策略
     *
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        int count = 111;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        Stream.iterate(0, i -> i + 1)
                .limit(count)
                .forEach(i -> {
                    threadPoolExecutor.execute(() -> {
                        log.info("执行任务: {}", i);
                        try {
                            if (i <= 3) {
                                Thread.sleep(2);
                            } else {
                                Thread.sleep(200);
                            }
                            countDownLatch.countDown();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                });
        countDownLatch.await();
    }


    @Test
    public void test02() throws Exception{
        Future<String> submit = threadPoolExecutor.submit(() -> {
            Thread.sleep(100);
            log.info("submit  run ... ");
            return "hello ";
        });

        Future<String> submit2 = threadPoolExecutor.submit(() -> {
            Thread.sleep(100);
            log.info("submit 1  run ... ");
            return " world ";
        });
        submit.get();
        submit2.get();
        log.info("run ... ");
    }


}