package com.weweibuy.webuy.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description
 * @Author durenhao
 * @Date 2019/2/6 21:43
 **/
@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello...product";
    }

}
