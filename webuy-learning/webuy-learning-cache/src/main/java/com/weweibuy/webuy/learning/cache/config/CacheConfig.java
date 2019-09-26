package com.weweibuy.webuy.learning.cache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

/**
 * @author durenhao
 * @date 2019/9/26 21:44
 **/
@Configuration
public class CacheConfig {

    @Bean("caffeineCache")
    @Primary
    public CacheManager caffeineCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        Caffeine caffeine = Caffeine.newBuilder()
                .initialCapacity(10)
                .maximumSize(10)
                .expireAfterWrite(50, TimeUnit.SECONDS);

        cacheManager.setAllowNullValues(true);
        cacheManager.setCaffeine(caffeine);
        return cacheManager;
    }


}
