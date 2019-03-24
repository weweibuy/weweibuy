package com.weweibuy.test.rx.concat;

import org.junit.Test;

public class RxConcatSubscribeTest {

    @Test
    public void subscribe() throws Exception {
        new RxConcatSubscribe().subscribe();
    }

    @Test
    public void asyncSubscribe() throws Exception {
        for(int i = 0; i < 10; i++){
            new RxConcatSubscribe().asyncSubscribe();
        }
        Thread.sleep(2111);
    }

}