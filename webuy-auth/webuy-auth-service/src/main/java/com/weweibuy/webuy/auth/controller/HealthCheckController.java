package com.weweibuy.webuy.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2020/3/5 21:37
 **/
@RestController
@RequestMapping("/endpoint")
public class HealthCheckController {

    @GetMapping("/_health")
    public ResponseEntity healthCheck() {
        return ResponseEntity.noContent().build();
    }


}
