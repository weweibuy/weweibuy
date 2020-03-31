package com.weweibuy.webuy.learning.redis.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author zhang.suxing
 * @date 2020/3/29 12:54
 **/
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //todo 分布式锁的实现 spring-boot-strart 版本不是2.0以上  可使用lua script 替代
    public void mockDistributeLock(String orderNo, String bizFlowNo) {
        stringRedisTemplate.opsForValue().setIfAbsent("", "");
    }
}
