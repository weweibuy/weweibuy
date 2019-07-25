package com.weweibuy.webuy.learning.spring.thead;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class ThreadPoolHolderTest {

    private ThreadPoolTaskExecutor taskExecutor;

    private ThreadPoolExecutor threadPoolExecutor;

    {
        taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setMaxPoolSize(3);
        taskExecutor.setThreadNamePrefix("async-");
        taskExecutor.setQueueCapacity(10);
        taskExecutor.initialize();
    }

    @Test
    public void test01() {
    }


}