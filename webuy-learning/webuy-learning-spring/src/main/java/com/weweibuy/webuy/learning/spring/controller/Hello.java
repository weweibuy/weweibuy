package com.weweibuy.webuy.learning.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/4/7 0:10
 **/
@RestController
public class Hello {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
