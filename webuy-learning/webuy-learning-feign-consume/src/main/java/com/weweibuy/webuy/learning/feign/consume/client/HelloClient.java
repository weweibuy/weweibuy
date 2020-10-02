package com.weweibuy.webuy.learning.feign.consume.client;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author durenhao
 * @date 2019/12/24 21:42
 **/
@FeignClient(value = "learning-feign-provider")
public interface HelloClient {

    @GetMapping("/hello")
    CommonDataResponse<String> hello();


    @PostMapping("/hello")
    CommonDataResponse<String> helloPost(@RequestHeader(value = "token") String token,
                                             CommonDataResponse commonJsonResponse,
                                         @RequestParam("sign") String sign);


}
