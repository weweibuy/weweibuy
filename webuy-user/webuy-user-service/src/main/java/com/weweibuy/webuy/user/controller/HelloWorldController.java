package com.weweibuy.webuy.user.controller;

import com.weweibuy.webuy.support.client.TestUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

/**
 * @ClassName HelloWorldController
 * @Description
 * @Author durenhao
 * @Date 2018/11/25 11:02
 **/
@RestController
public class HelloWorldController {

    @Autowired
    private TestUserClient testUserClient;


    @RequestMapping("/hello")
    public String sayHello(){
        return "hello..user...";
    }


    @RequestMapping("/helloSso")
    public String sayHelloSSO(){
        return "hello..SSO...";
    }

    @GetMapping("/hello/users")
    public String testUsers(){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("tom");
        hashSet.add("jack");
        hashSet.add("lucy");
        return testUserClient.getUsers(hashSet);
    }


}
