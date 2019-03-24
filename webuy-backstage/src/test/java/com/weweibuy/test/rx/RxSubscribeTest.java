package com.weweibuy.test.rx;

import org.junit.Test;

public class RxSubscribeTest {

    @Test
    public void asyncSubscribe() throws Exception {
        new RxSubscribe().asyncSubscribe();
        Thread.sleep(1111);
    }

    @Test
    public void subscribe() throws Exception {
        new  RxSubscribe().subscribe();
    }

}