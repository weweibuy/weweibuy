package com.weweibuy.auth.core.config.properties;

import com.weweibuy.auth.core.config.eum.LoginResponseType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName SecurityProperties
 * @Description
 * @Author durenhao
 * @Date 2018/12/15 20:25
 **/
@ConfigurationProperties(prefix = "webuy.security")
@Data
public class SecurityProperties {

    /** 登录成功的响应方式， 默认重定向 */
    private LoginResponseType loginResponseType = LoginResponseType.REDIRECT;

    private ValidateCodeProperties ValidateCodeProperties = new ValidateCodeProperties();

    private LoginProperties loginProperties = new LoginProperties();

}
