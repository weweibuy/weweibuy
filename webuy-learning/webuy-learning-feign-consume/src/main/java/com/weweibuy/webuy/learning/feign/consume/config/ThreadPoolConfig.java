package com.weweibuy.webuy.learning.feign.consume.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author durenhao
 * @date 2019/12/26 23:21
 **/
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ExecutorService executorService() {
        return new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(100), new CustomizableThreadFactory("learning-feign-async-"));
    }


}
