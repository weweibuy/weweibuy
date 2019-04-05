package com.weweibuy.webuy.auth.core.config.properties;

import lombok.Data;

/**
 * @ClassName QQProperties
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 13:00
 **/
@Data
public class QQProperties extends AbstractSocialProperties{

    /** 处理登录前缀,  /auth 也是SpringSocial 的默认配置 */
    private String processesUrl = "/auth";

    /** 服务提供商编号，也是处理登录请求的后缀  与 processesUrl合起来为  /auth/qq */
    private String providerId = "qq";

}
