package com.weweibuy.webuy.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloWorldController
 * @Description
 * @Author durenhao
 * @Date 2018/11/25 11:02
 **/
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello..user...";
    }


    @RequestMapping("/helloSso")
    public String sayHelloSSO(){
        return "hello..SSO...";
    }


}
