package com.weweibuy.webuy.learning.feign.consume.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author durenhao
 * @date 2020/1/31 14:41
 **/
@FeignClient(value = "learning-spring")
public interface LearningClient {

    @GetMapping("/api/v1/test/hello")
    String hello3();

}
