package com.weweibuy.learning.webflux.service;

import com.weweibuy.learning.webflux.model.dto.JsonResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2019/9/30 21:41
 **/
@Slf4j
@CacheConfig(cacheNames = "helloService")
@Service
public class HelloService {

    @Cacheable(key = "'getData'")
    public JsonResponseDto<String> getData() {
        log.info("查询数据");
        return JsonResponseDto.success("");
    }


}
