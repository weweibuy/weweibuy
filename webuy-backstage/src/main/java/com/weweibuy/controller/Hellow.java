package com.weweibuy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Hellow
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/22 13:07
 **/
@RestController()
@RequestMapping(produces="application/json;charset=UTF-8")
public class Hellow {


    @GetMapping("/hello")
    public String hello(){
        return "hello-8001";
    }




}
