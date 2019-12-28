package com.weweibuy.webuy.learning.spring.client;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author durenhao
 * @date 2019/12/24 21:42
 **/
@FeignClient(value = "learning-feign-provider")
public interface HelloClient {

    @GetMapping("/hello")
    CommonJsonResponse<String> hello();


}
