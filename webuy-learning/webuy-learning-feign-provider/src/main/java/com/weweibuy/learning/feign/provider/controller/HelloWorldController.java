package com.weweibuy.learning.feign.provider.controller;

import com.weweibuy.webuy.common.model.dto.CommonDataJsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author durenhao
 * @date 2019/12/24 21:33
 **/
@Slf4j
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public CommonDataJsonResponse<String> helloGet() {
        return CommonDataJsonResponse.success("hello i am provider get method");
    }


    @PostMapping("/hello")
    public CommonDataJsonResponse<String> helloPost(@RequestBody CommonDataJsonResponse<String> commonJsonResponse,
                                                @RequestHeader(value = "token") String token,
                                                String sign) {
        log.info("date : {}", commonJsonResponse.getData());
        log.info("token : {}", token);
        log.info("sign : {}", sign);
        return CommonDataJsonResponse.success("hello i am provider post method");
    }


}
