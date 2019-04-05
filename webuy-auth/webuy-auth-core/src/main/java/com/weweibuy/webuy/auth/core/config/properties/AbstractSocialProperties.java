package com.weweibuy.webuy.auth.core.config.properties;

import lombok.Data;

/**
 * 封装appId与appSecurity
 * @ClassName AbstractSocialProperties
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 13:14
 **/
@Data
public class AbstractSocialProperties {

    private String appId;

    private String appSecurity;
}
