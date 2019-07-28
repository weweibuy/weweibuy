package com.weweibuy.webuy.learning.spring.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2019/7/27 10:49
 **/
@Slf4j
@Service
public class SentinelService {


    @SentinelResource(value = "sentinelService.service", blockHandler = "exceptionHandler", fallback = "helloFallback")
    public void service(){
        log.info("SentinelService.....action....");
    }

    public void exceptionHandler(BlockException ex) {
        log.error("exceptionHandler....");
    }

    public void helloFallback() {
        log.warn("helloFallback....");

    }

}
