package com.weweibuy.webuy.learning.spring.thead;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author durenhao
 * @date 2019/10/13 12:00
 **/
@Slf4j
public class ThreadException {

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        log.info("系统启动");
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                log.error("UnCaughtException: {}", e.getMessage(), e);
            }
        });

        ThreadPoolHolder.getFixPoll().execute(() -> {
            log.info("业务1正在执行.....");
            if(true){
                throw new RuntimeException("业务1执行时系统崩溃");
            }
            COUNT_DOWN_LATCH.countDown();
        });

        ThreadPoolHolder.getFixPoll().execute(() -> {
            log.info("业务2正在执行.....");
            if(true){
                throw new RuntimeException("业务2执行时系统崩溃");
            }
            COUNT_DOWN_LATCH.countDown();
        });

        COUNT_DOWN_LATCH.await();
    }


}
