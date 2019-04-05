package com.weweibuy.webuy.auth.core.validate.code;

/**
 * 短信验证码发送器
 * @ClassName SmsValidateCodeSender
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 13:16
 **/
public interface SmsValidateCodeSender {

    void send(String mobile, String code);

}
