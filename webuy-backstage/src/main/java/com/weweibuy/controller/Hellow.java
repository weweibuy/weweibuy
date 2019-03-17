package com.weweibuy.controller;

import com.weweibuy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName Hellow
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/22 13:07
 **/
@RestController
@RequestMapping(produces="application/json;charset=UTF-8")
@CacheConfig(cacheNames = "users")
@Slf4j
public class Hellow {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        throw new RuntimeException();
//        return "这个资源需要登录...";
    }

    @GetMapping("/helloRedirect")
    public String helloRedirect(){
        return "redirect:localhost:8080/backstage/hello";
    }

    @GetMapping("/cache/users")
    @Cacheable(key = "#root.methodName+ '[' + #name + ']'")
    public List users(String name){
        return userService.selectByExample(null);
    }

    @GetMapping("/cache/refresh")
    @CacheEvict(key = "1")
    public String reflashCache(){
        return "suerccess";
    }

    @GetMapping("/cache/refreshAll")
    @CacheEvict(allEntries = true)
    public String reflashCacheAll(){
        return "suerccess";
    }

    @GetMapping("cache/update")
    @CacheEvict(key = "1", beforeInvocation = true)
    @CachePut(key = "1")
    public List update(){
        return userService.selectPageList(1, 3).getRows();
    }


    @GetMapping("/redis")
    public String redis(){
        redisTemplate.opsForValue().set("k2", "v2");
        redisTemplate.opsForValue().get("k1");
        Object v1 = stringRedisTemplate.opsForValue().get("k1");
        stringRedisTemplate.opsForValue().set("k3", "v3");
        Object v2 = redisTemplate.opsForValue().get("k2");

        stringRedisTemplate.opsForHash().put("hk1","hf1", "hv1");
        Object o = stringRedisTemplate.opsForHash().get("hk1", "hf1");
        return v1+"||||||"+v2;
    }



}
