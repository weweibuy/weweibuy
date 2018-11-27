package com.weweibuy.user.service;

import com.weweibuy.dto.WebResult;

/**
 * @ClassName UserService
 * @Description
 * @Author durenhao
 * @Date 2018/11/25 17:06
 **/
public interface UserService {

    WebResult sendVerificationCode(String phoneNum);

    WebResult registerUser(String phone, String pwd);

}
