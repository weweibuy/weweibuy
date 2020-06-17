package com.weweibuy.webuy.auth.controller;

import com.weweibuy.framework.common.core.model.dto.CommonCodeJsonResponse;
import com.weweibuy.framework.common.core.model.dto.CommonDataJsonResponse;
import com.weweibuy.webuy.auth.model.dto.AuthorizationReq;
import com.weweibuy.webuy.auth.model.dto.AuthorizationResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2020/2/29 20:10
 **/
@RestController
@RequestMapping("/gw")
@Slf4j
public class GatewayAuthenticationController {

    @PostMapping("/authorize")
    public CommonCodeJsonResponse authorize(@RequestBody AuthorizationReq AuthorizationReq) {
        log.info("请求: {}", AuthorizationReq);
        AuthorizationResp resp = new AuthorizationResp();
        resp.setAppId("124");
        resp.setAppKey("app_key_123");
        resp.setAppSecret("app_secret_123");
        resp.setAppId("service_123");
        return CommonDataJsonResponse.success(resp);
    }


}
