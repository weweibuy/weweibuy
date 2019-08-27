package com.weweibuy.webuy.learning.spring.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author durenhao
 * @date 2019/8/25 10:40
 **/
@Slf4j
public class ConcurrentTest {


    @Test
    public void test01()throws Exception{
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        boolean b = atomicBoolean.get();
        boolean b1 = atomicBoolean.compareAndSet(false, true);
        log.info("值为: {}", b1);
    }

}
