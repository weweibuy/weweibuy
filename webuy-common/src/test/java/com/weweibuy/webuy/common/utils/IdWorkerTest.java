package com.weweibuy.webuy.common.utils;

import com.weweibuy.framework.common.core.utils.IdWorker;
import org.junit.Test;

public class IdWorkerTest {


    @Test
    public void getNextId() throws Exception {
        int i = 3 << 3 | 23;
        System.err.println(i);
        System.err.println(3268 + 24);
        long nextId = IdWorker.nextId();
        System.err.println(nextId);
    }

}