package com.weweibuy.webuy.auth.core.config.eum;

import com.weweibuy.webuy.auth.core.config.constants.SecurityConstants;

/**
 * 验证码类型
 * @ClassName ValidateCodeType
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 10:37
 **/
public enum ValidateCodeType {

    /** 手机短信验证码 */
    SMS{
        @Override
        public String getParamName() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },

    /** 图片验证码 */
    IMAGE{
        @Override
        public String getParamName() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    public abstract String getParamName();

}
