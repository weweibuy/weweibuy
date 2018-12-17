package com.weweibuy.auth.core.config.properties;

import lombok.Data;

/**
 * 生成验证码的配置
 * @ClassName ValidateCodeProperties
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 9:47
 **/
@Data
public class ValidateCodeProperties {

    private Integer length = 6;

    private Long expireTime = 600L;

}
