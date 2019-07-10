package com.weweibuy.webuy.gateway.spring.controller;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.common.eum.CommonWebMsg;
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
    public Mono<ResponseEntity<CommonJsonResponse>> fallback() {
        return Mono.just(ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(CommonJsonResponse.fail(CommonWebMsg.FALL_BACK)));
    }

}
