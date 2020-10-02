package com.weweibuy.webuy.gateway.spring.controller;

import com.weweibuy.framework.common.core.model.dto.CommonCodeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author durenhao
 * @date 2019/4/21 0:31
 **/
@RestController
public class GatewayFallbackController {

    @RequestMapping("/default-fallback")
    public Mono<ResponseEntity<CommonCodeResponse>> fallback() {
        return Mono.just(ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(CommonCodeResponse.unknownException()));
    }

}
