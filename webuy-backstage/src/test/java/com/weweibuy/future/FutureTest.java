package com.weweibuy.future;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName FutureTest
 * @Description
 * @Author durenhao
 * @Date 2019/3/30 10:44
 **/
@Slf4j
public class FutureTest {


    @Test
    public void test() throws ExecutionException, InterruptedException {
        Future future = new Future() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                log.info("canceled");
                return false;
            }

            @Override
            public boolean isCancelled() {
                log.info("isCancelled");
                return false;
            }

            @Override
            public boolean isDone() {
                log.info("isDone");
                return false;
            }

            @Override
            public Object get() throws InterruptedException, ExecutionException {
                log.error("get...");
                return "result...";
            }

            @Override
            public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                log.error("get... {}  {}", timeout, unit);
                return "result...";
            }
        };
        future.get();
        future.get();
    }
}
