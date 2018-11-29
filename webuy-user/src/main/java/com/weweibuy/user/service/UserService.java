package com.weweibuy.user.service;

import com.weweibuy.dto.WebResult;
import com.weweibuy.user.model.po.WebuyUser;
import com.weweibuy.user.model.po.WebuyUserExample;
import com.weweibuy.user.service.base.BaseCrudService;

/**
 * @ClassName UserService
 * @Description
 * @Author durenhao
 * @Date 2018/11/25 17:06
 **/
public interface UserService extends BaseCrudService<WebuyUser, WebuyUserExample>{

    WebResult sendVerificationCode(String phoneNum);

    WebResult registerUser(String phone, String pwd);

}
