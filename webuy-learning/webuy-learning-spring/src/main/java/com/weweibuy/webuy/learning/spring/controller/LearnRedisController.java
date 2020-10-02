package com.weweibuy.webuy.learning.spring.controller;

import com.weweibuy.framework.common.core.model.dto.CommonCodeResponse;
import com.weweibuy.framework.common.core.utils.JackJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author durenhao
 * @date 2019/4/21 20:51
 **/
@RestController
@RequestMapping("/redis")
public class LearnRedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/add-hash")
    private String addHash() {
        redisTemplate.opsForHash().put("hk1", "k1", JackJsonUtils.write(CommonCodeResponse.success()));
        redisTemplate.opsForHash().put("hk1", "k2", JackJsonUtils.write(CommonCodeResponse.unknownException()));

        return "success";
    }

    @RequestMapping("/get-hash")
    private Object getHash() {
        HashOperations<String, Object, Object> forHash = redisTemplate.opsForHash();
        Map<Object, Object> hk1 = forHash.entries("hk1");
        List<Object> objects = forHash.values("hk1");
        return forHash.get("hk1", "k1");
    }

}
