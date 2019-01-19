package com.weweibuy.user.service;

import com.weweibuy.user.common.model.dto.UserWebResult;
import com.weweibuy.user.common.model.po.WebuyUser;
import com.weweibuy.user.common.model.po.WebuyUserExample;
import com.weweibuy.user.service.base.BaseCrudService;

/**
 * @ClassName UserService
 * @Description
 * @Author durenhao
 * @Date 2018/11/25 17:06
 **/
public interface UserService extends BaseCrudService<WebuyUser, WebuyUserExample>{

    UserWebResult sendVerificationCode(String phoneNum);

    UserWebResult registerUser(String phone, String pwd);

    UserWebResult checkAccountExist(String phoneNum);

    UserWebResult loadUserByUsername(String username) throws Exception;
}
