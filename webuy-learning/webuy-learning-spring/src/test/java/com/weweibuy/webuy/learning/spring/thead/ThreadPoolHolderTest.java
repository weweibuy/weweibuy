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

    private ExecutorService ioThreadPool;


    {
        ioThreadPool = new ThreadPoolExecutor(1, 2, 60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new CustomizableThreadFactory("io-thread-"),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    {
        taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(3);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setThreadNamePrefix("spring-async-");
        taskExecutor.setQueueCapacity(100);
        taskExecutor.initialize();
        threadPoolExecutor = new ThreadPoolExecutor(2, 10, 60L,
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
    public void test02() throws Exception {
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
        String s1 = submit.get();
        submit2.get();
        String s = submit.get();
        log.info("run ... {}, {}", s1, s);
    }

    /**
     * 线程池死锁
     *
     * @throws Exception
     */
    @Test
    public void test03() throws Exception {
        Future<String> stringFuture1 = threadPoolExecutor.submit(() -> {
            log.info("任务 1 运行");
            Future<String> stringFuture2 = threadPoolExecutor.submit(() -> {
                log.info("任务 2 运行");
                Future<String> stringFuture3 = threadPoolExecutor.submit(() -> {
                    log.info("任务 3 运行");
                    return "task 3";
                });
                return "task 2" + "  and " + stringFuture3.get();
            });
            return "task 1" + "  " + stringFuture2.get();
        });

        String s = stringFuture1.get();
        log.info("运行结果: {}", s);
    }

    @Test
    public void test04() throws Exception {
        Future<String> stringFuture1 = ioThreadPool.submit(() -> {
            log.info("任务 1 运行");
            Future<String> stringFuture2 = ioThreadPool.submit(() -> {
                log.info("任务 2 运行");
                Future<String> stringFuture3 = ioThreadPool.submit(() -> {
                    log.info("任务 3 运行");
                    return "task 3";
                });
                return "task 2 " + "  and " + stringFuture3.get();
            });
            return "task 1" + "  " + stringFuture2.get();
        });

        boolean done = stringFuture1.isDone();
        boolean cancelled  = stringFuture1.isCancelled();
        log.info("id done:{} , is cancelled: {}", done, cancelled);
        String s = stringFuture1.get();
        boolean done1 = stringFuture1.isDone();
        boolean cancelled1 = stringFuture1.isCancelled();
        log.info("id done:{}; is cancelled: {} ", done1, cancelled1);

        log.info("运行结果: {}", s);
    }

}