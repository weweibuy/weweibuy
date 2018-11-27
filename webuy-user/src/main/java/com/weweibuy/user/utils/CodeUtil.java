package com.weweibuy.user.utils;

/**
 * @ClassName CodeUtil
 * @Description 各科验证码工具
 * @Author durenhao
 * @Date 2018/11/25 16:32
 **/
public class CodeUtil {

    public static Integer getPhoneVerificationCode(){
        return (int)((Math.random()*9+1)*100000);
    }



}
