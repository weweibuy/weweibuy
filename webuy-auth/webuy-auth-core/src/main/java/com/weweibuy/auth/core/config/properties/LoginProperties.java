package com.weweibuy.auth.core.config.properties;

import com.weweibuy.auth.core.config.constants.SecurityConstants;
import lombok.Data;

/**
 * @ClassName LoginProperties
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 19:36
 **/
@Data
public class LoginProperties {

    private String formLoginUrl = SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM;

    private String mobileLoginUrL = SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE;

}
