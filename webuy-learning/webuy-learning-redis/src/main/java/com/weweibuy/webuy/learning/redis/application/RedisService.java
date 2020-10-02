package com.weweibuy.webuy.learning.redis.application;

import com.weweibuy.framework.common.core.utils.JackJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhang.suxing
 * @date 2020/3/29 12:54
 **/
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private RedisTemplate redisTemplate;

    //todo 分布式锁的实现 spring-boot-strart 版本不是2.0以上  可使用lua script 替代
    public void mockDistributeLock(String orderNo, String bizFlowNo) {
        stringRedisTemplate.opsForValue().setIfAbsent("", "");
        Set<String> objects = new HashSet<>();
        String json = JackJsonUtils.write(objects);
        redisTemplate.opsForValue().set("wangwei", json);
        Object wangwei = redisTemplate.opsForValue().get("wangwei");
        Set set = JackJsonUtils.readValue((String) wangwei, Set.class);


        redisTemplate.opsForHash().put("wangwei", "hwangwei", json);

    }
}
