package com.weweibuy.learning.data.sync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

/**
 * @author durenhao
 * @date 2019/10/13 22:19
 **/
@SpringBootApplication
public class DataSyncApplication {

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DataSyncApplication.class, args);
        COUNT_DOWN_LATCH.await();
    }


}
