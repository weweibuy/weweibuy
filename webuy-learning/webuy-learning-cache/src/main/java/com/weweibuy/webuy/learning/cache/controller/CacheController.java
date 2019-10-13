package com.weweibuy.webuy.learning.cache.controller;

import com.weweibuy.webuy.learning.cache.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/9/26 22:24
 **/
@Slf4j
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/get/{name}")
    public Object get(@PathVariable("name") String name) {
        return cacheService.getCache(name);
    }

    @GetMapping("/hello")
    public ResponseEntity get() throws InterruptedException {
        log.info("收到请求");
        Thread.sleep(100);
        return ResponseEntity.status(HttpStatus.OK).body(cacheService.getCache2());
    }


}
