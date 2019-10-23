package com.weweibuy.webuy.learning.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author durenhao
 * @date 2019/10/23 22:14
 **/
@Configuration
public class ThreadPoolConfig {


    @Bean
    public Executor executors(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setThreadNamePrefix("async-");
        return threadPoolTaskExecutor;
    }

}
