package com.weweibuy.learning.es.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author durenhao
 * @date 2019/8/5 0:24
 **/
@Configuration
public class ThreadConfig {

    @Bean
    public Executor executors() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(20);
        executor.setCorePoolSize(10);
        executor.setQueueCapacity(100000);
        executor.setThreadNamePrefix("async-");
        return executor;
    }

}
