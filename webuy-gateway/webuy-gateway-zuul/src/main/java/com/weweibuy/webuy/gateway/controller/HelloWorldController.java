package com.weweibuy.webuy.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloWorldController
 * @Description
 * @Author durenhao
 * @Date 2019/1/1 14:26
 **/
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(){
        return "hello....";
    }

    @GetMapping("/hellosso")
    public String helloSso(){
        return "hellosoo....";
    }


}
