package com.weweibuy.webuy.learning.feign.consume.controller;

import com.weweibuy.webuy.common.model.dto.CommonDataJsonResponse;
import com.weweibuy.webuy.learning.feign.consume.client.HelloClient;
import com.weweibuy.webuy.learning.feign.consume.client.LearningClient;
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

    private final LearningClient learningClient;

    private final ExecutorService executorService;


    public HelloWorldController(HelloClient helloClient, LearningClient learningClient, ExecutorService executorService) {
        this.helloClient = helloClient;
        this.learningClient = learningClient;
        this.executorService = executorService;
    }

    @GetMapping("/hello")
    public Object hello() throws Exception {
        return helloClient.hello();
    }

    @GetMapping("/hello2")
    public Object hello2() {
        return helloClient.helloPost("token123", CommonDataJsonResponse.success("success"), "sign123");
    }


    @GetMapping("/test/hello")
    public Object testHello() throws Exception {
        return learningClient.hello3();
    }

}
