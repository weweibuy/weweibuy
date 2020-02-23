package com.weweibuy.webuy.learning.spring.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author durenhao
 * @date 2020/2/15 11:10
 **/
@RestController
@RequestMapping("/json")
public class MultiJsonObjectController {


    @PostMapping("/multi")
    public Object multiJson(@RequestBody Map<String, String> stringMap) {
        return stringMap;
    }


    @Data
    public static class User {

        private String userName;

        private Integer age;

    }

    @Data
    public static class Dog {

        private String dogName;

        private Integer age;

    }

}
