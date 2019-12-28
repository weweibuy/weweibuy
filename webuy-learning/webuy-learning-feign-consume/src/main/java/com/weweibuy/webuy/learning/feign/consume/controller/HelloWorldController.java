package com.weweibuy.webuy.learning.feign.consume.controller;

import com.weweibuy.webuy.learning.feign.consume.client.HelloClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

/**
 * @author durenhao
 * @date 2019/12/24 21:42
 **/
@RestController
public class HelloWorldController {

    private final HelloClient helloClient;

    private final ExecutorService executorService;


    public HelloWorldController(HelloClient helloClient, ExecutorService executorService) {
        this.helloClient = helloClient;
        this.executorService = executorService;
    }

    @GetMapping("/hello")
    public Object hello() throws Exception {
        return  helloClient.hello();
    }


}
