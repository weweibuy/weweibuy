package com.weweibuy.auth.core.config.properties;

import lombok.Data;

/**
 * @ClassName WeiXinProperties
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 22:01
 **/
@Data
public class WeiXinProperties extends AbstractSocialProperties {

    /** 处理登录前缀,  /auth 也是SpringSocial 的默认配置 */
    private String processesUrl = "/auth";

    /** 服务提供商编号，也是处理登录请求的后缀  与 processesUrl合起来为  /auth/qq */
    private String providerId = "weixin";

}
