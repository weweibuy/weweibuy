package com.weweibuy.webuy.auth.controller;

import com.weweibuy.webuy.common.model.dto.CommonCodeJsonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2020/2/29 20:10
 **/
@RestController
@RequestMapping("/gw")
public class GatewayAuthenticationController {


    @PostMapping("/authorize")
    public CommonCodeJsonResponse authorize() {
        return CommonCodeJsonResponse.success();
    }


}
