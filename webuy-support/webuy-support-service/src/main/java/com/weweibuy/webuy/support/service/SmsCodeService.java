package com.weweibuy.webuy.support.service;

/**
 * 发送手机验证码服务
 * @InterfaceName SmsCodeService
 * @Description
 * @Author durenhao
 * @Date 2019/1/19 22:12
 **/
public interface SmsCodeService {

    void sendSmsCode(String mobile);

    String getSmsCode(String mobile);

}
