package com.weweibuy.webuy.learning.feign.consume.controller;

import com.weweibuy.webuy.learning.feign.consume.client.HelloClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/12/24 21:42
 **/
@RestController
public class HelloWorldController {

    private final HelloClient helloClient;


    public HelloWorldController(HelloClient helloClient) {
        this.helloClient = helloClient;
    }

    @GetMapping("/hello")
    public Object hello() {
        return helloClient.hello();
    }


}
