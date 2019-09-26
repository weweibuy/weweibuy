package com.weweibuy.webuy.learning.cache.controller;

import com.weweibuy.webuy.learning.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/9/26 22:24
 **/
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/get/{name}")
    public Object get(@PathVariable("name") String name) {
        return cacheService.getCache(name);
    }

}
