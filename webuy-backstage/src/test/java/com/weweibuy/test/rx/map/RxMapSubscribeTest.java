package com.weweibuy.test.rx.map;

import com.weweibuy.webuy.backstage.test.rx.map.RxMapSubscribe;
import org.junit.Test;

public class RxMapSubscribeTest {

    @Test
    public void subscribe() throws Exception {
        new RxMapSubscribe().subscribe();
    }

    @Test
    public void asyncSubscribe() throws Exception {
        new RxMapSubscribe().asyncSubscribe();
        Thread.sleep(1111);
    }

}