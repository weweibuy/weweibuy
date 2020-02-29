package com.weweibuy.webuy.auth.model.dto;

import lombok.Data;

/**
 * @author durenhao
 * @date 2020/2/24 21:24
 **/
@Data
public class AuthorizationResp {

    private String appId;

    private String appName;

    private String appKey;

    private String appSecret;

    private String service;

}
