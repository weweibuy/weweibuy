package com.weweibuy.webuy.learning.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author durenhao
 * @date 2019/4/7 0:10
 **/
@RestController
@RequestMapping("/api/v1")
public class Hello {

    @RequestMapping("/hello")
    public String hello(HttpServletResponse response){
        Cookie cookie = new Cookie("test_gateway_cookie", "test_gateway_cookie_value");
        response.addCookie(cookie);
        response.addHeader("test_gateway_header", "test_gateway_header_value");
        return "hello.. i am learn spring...";
    }

    @RequestMapping("/test/hello")
    public String hello2(){
        return "test hello.. i am learn spring...2";
    }

}
