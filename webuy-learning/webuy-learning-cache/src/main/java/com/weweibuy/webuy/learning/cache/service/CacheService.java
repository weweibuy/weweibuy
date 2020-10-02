package com.weweibuy.webuy.learning.cache.service;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
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
    public CommonDataResponse<String> getCache(String name){
        log.info("查询数据");
        return CommonDataResponse.success(name);
    }

    @Cacheable(key = "'getCache2'")
    public CommonDataResponse<String> getCache2(){
        log.info("查询数据");
        return CommonDataResponse.success("");
    }

}
