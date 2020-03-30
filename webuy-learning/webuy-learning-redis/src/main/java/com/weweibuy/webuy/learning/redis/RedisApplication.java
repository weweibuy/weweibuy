package com.weweibuy.webuy.learning.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * 1.docker 安装redis
 * 2.引入redis stater
 * 3.配置redis
 * 4.测试缓存
 *    原理：CacheManager==Cache  缓存组件来时间缓存中存取数据
 *          1）引入redis starter 容器中保存的是RedisCacheManager
 *          2) RedisCacheManager创建缓存 RedisCache 来作为缓存组件
 *          3）RedisCache 操作redis 来缓存数据
 *
 */
//@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }


}
