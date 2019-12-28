package com.weweibuy.learning.feign.provider.controller;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/12/24 21:33
 **/
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public CommonJsonResponse<String> hello() throws InterruptedException {
        Thread.sleep(200);
        return CommonJsonResponse.success("hello i am provider");
    }


}
