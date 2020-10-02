package com.weweibuy.webuy.learning.feign.consume.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.webuy.learning.feign.consume.client.HelloClient;
import com.weweibuy.webuy.learning.feign.consume.client.LearningClient;
import com.weweibuy.webuy.learning.feign.consume.service.AsyncConsumeService;
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

    private final AsyncConsumeService asyncConsumeService;


    public HelloWorldController(HelloClient helloClient, LearningClient learningClient, ExecutorService executorService, AsyncConsumeService asyncConsumeService) {
        this.helloClient = helloClient;
        this.learningClient = learningClient;
        this.executorService = executorService;
        this.asyncConsumeService = asyncConsumeService;
    }

    @GetMapping("/hello")
    public Object hello() throws Exception {
        return helloClient.hello();
    }

    @GetMapping("/hello-sync")
    public Object helloSync() throws Exception {
        asyncConsumeService.consume();;
        return "success";
    }

    @GetMapping("/hello2")
    public Object hello2() {
        return helloClient.helloPost("token123", CommonDataResponse.success("success"), "sign123");
    }


    @GetMapping("/test/hello")
    public Object testHello() throws Exception {
        return learningClient.hello3();
    }

}
