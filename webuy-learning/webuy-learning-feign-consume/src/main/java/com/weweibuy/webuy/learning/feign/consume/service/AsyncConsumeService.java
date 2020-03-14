package com.weweibuy.webuy.learning.feign.consume.service;

import com.weweibuy.webuy.learning.feign.consume.client.HelloClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2020/3/14 20:33
 **/
@Slf4j
@Service
public class AsyncConsumeService {

    private final HelloClient helloClient;

    public AsyncConsumeService(HelloClient helloClient) {
        this.helloClient = helloClient;
    }

    @Async
    public void consume() {
        log.info("consume async ");
        helloClient.hello();
    }


}
