package com.weweibuy.test.rx.defer;

import com.weweibuy.webuy.backstage.test.rx.defer.RxDefSubscribe;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class RxDefSubscribeTest {

    private ExecutorService executor = Executors.newFixedThreadPool(3);

    @Test
    public void subscribe() throws Exception {
        Future<String> future = new RxDefSubscribe().subscribe();
        // 可以获取 发送的 消息
        String s = future.get();
        log.info("获取到值 {}", s);
        Thread.sleep(1110);
    }

}