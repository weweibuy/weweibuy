package com.weweibuy.webuy.common.utils;

import org.junit.Test;

public class IdWorkerTest {


    @Test
    public void getNextId() throws Exception {
        int i = 3 << 3 | 23;
        System.err.println(i);
        System.err.println(3268 + 24);
        long nextId = IdWorker.getNextId();
        System.err.println(nextId);
    }

}