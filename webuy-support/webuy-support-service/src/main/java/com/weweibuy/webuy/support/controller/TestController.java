package com.weweibuy.webuy.support.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/8/14 22:12
 **/
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/users")
    public String test01(String[] userList){
        log.info("请求参数: {}", userList);
        return "success";
    }



}
