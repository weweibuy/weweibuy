package com.weweibuy.webuy.gateway.spring.controller;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.common.eum.CommonWebMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/4/21 0:31
 **/
@RestController
public class GatewayFallbackController {

    @RequestMapping("/default-fallback")
    public ResponseEntity fallback(){
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(CommonJsonResponse.fail(CommonWebMsg.FALL_BACK));
    }

}
