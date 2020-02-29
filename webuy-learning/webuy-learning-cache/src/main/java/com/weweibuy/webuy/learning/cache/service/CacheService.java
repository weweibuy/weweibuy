package com.weweibuy.webuy.learning.cache.service;

import com.weweibuy.webuy.common.model.dto.CommonDataJsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2019/9/25 22:30
 **/
@Slf4j
@Service
@CacheConfig(cacheNames= "test")
public class CacheService {

    @Cacheable(key = "#name")
    public CommonDataJsonResponse<String> getCache(String name){
        log.info("查询数据");
        return CommonDataJsonResponse.success(name);
    }

    @Cacheable(key = "'getCache2'")
    public CommonDataJsonResponse<String> getCache2(){
        log.info("查询数据");
        return CommonDataJsonResponse.success("");
    }

}
