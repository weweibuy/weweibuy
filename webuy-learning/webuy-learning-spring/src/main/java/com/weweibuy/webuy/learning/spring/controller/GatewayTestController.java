package com.weweibuy.webuy.learning.spring.controller;

import com.weweibuy.webuy.learning.spring.model.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author durenhao
 * @date 2020/2/28 20:07
 **/
@RestController
@RequestMapping("/learning-spring")
public class GatewayTestController {


    @GetMapping("/query")
    public Object query(UserInfo userInfo) {
        return Res.success(userInfo);
    }


    @PostMapping("/postJson")
    public Object postJson(@RequestBody UserInfo userInfo) {
        return Res.success(userInfo);
    }

    @PostMapping("/postForm")
    public Object postForm(UserInfo userInfo) {
        return Res.success(userInfo);
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Res<T> {

        private String code;
        private String msg;
        private T data;


        public static <T> Res success(T data) {
            return new Res<>("0", "success", data);
        }

    }


}
