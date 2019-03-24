package com.weweibuy.test.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/**
 * @ClassName AsyncService
 * @Description
 * @Author durenhao
 * @Date 2019/3/21 22:51
 **/
@Service
public class AsyncService {


    @Async("Executor1")
    public void async1() throws InterruptedException {
        Thread.sleep(2500);
        System.err.println(Thread.currentThread().getName());
        throw new RuntimeException("chu cuo le ");
    }

    @Async("Executor1")
    public AsyncResult<String> asyncFeature1() throws InterruptedException {
        Thread.sleep(1500);
        System.err.println(Thread.currentThread().getName());
        return new AsyncResult("hello");
    }

    @Async("Executor2")
    public void async2() throws InterruptedException {
        Thread.sleep(1500);
        System.err.println(Thread.currentThread().getName());
    }

    @Async("Executor1")
    public void asyncFeature2(){
        System.err.println(Thread.currentThread().getName());
    }

}
