package com.weweibuy.webuy.auth.core.validate.code.impl;

import com.weweibuy.webuy.auth.core.validate.code.SmsValidateCodeSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName DefaultSmsValidateCodeSender
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 13:22
 **/
@Slf4j
@Component
public class DefaultSmsValidateCodeSender implements SmsValidateCodeSender {

    @Override
    public void send(String mobile, String code) {
        log.info("向手机：{} 发送验证码：{}", mobile, code);
    }
}
