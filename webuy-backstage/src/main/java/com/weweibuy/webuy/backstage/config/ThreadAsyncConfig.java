package com.weweibuy.webuy.backstage.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;


@Configuration
@EnableAsync//开启对异步任务的支持
public class ThreadAsyncConfig implements AsyncConfigurer {

    private final int corePoolSize = 5;
    private final int maxPoolSize = 10;
    private final int queueCapacity = 3;
    private final boolean waitForTasksToCompleteOnShutdown = false;
    private final int waitTerminationSeconds = 2;
    private final String threadNamePrefix = "Async-Thread-1";

    @Bean("Executor1")
    public Executor AsyncExecutor() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        //设置核心线程数
        threadPool.setCorePoolSize(corePoolSize);
        //设置最大线程数
        threadPool.setMaxPoolSize(maxPoolSize);
        //线程池所使用的缓冲队列
        threadPool.setQueueCapacity(queueCapacity);
        //等待任务在关机时完成--表明等待所有线程执行完
        threadPool.setWaitForTasksToCompleteOnShutdown(waitForTasksToCompleteOnShutdown);
        // 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
        threadPool.setAwaitTerminationSeconds(waitTerminationSeconds);
        //  线程名称前缀
        threadPool.setThreadNamePrefix(threadNamePrefix);
        // 初始化线程
        threadPool.initialize();
        return threadPool;
    }

    @Bean("Executor2")
    public Executor AsyncExecutor2() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        //设置核心线程数
        threadPool.setCorePoolSize(corePoolSize);
        //设置最大线程数
        threadPool.setMaxPoolSize(maxPoolSize);
        //线程池所使用的缓冲队列
        threadPool.setQueueCapacity(queueCapacity);
        //等待任务在关机时完成--表明等待所有线程执行完
        threadPool.setWaitForTasksToCompleteOnShutdown(waitForTasksToCompleteOnShutdown);
        // 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
        threadPool.setAwaitTerminationSeconds(waitTerminationSeconds);
        //  线程名称前缀
        threadPool.setThreadNamePrefix("Async-Thread-2");
        // 初始化线程
        threadPool.initialize();
        return threadPool;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable ex, Method method, Object... params) {
                System.err.println(ex.getMessage());
            }
        };
    }
}
