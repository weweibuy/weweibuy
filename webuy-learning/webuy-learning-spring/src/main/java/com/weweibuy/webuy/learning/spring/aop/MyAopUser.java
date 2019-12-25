package com.weweibuy.webuy.learning.spring.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/12/25 22:30
 **/
@RestController
public class MyAopUser {

    @GetMapping("/aop/test")
    @AopAnnotation
    public String hello() {
        return "hello";
    }


}
