package com.weweibuy.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description
 * @Author durenhao
 * @Date 2018/12/15 10:53
 **/
@RestController
public class HelloController {

    @PostMapping("/hello")
    public String hello(){
        return "hello";
    }



}
