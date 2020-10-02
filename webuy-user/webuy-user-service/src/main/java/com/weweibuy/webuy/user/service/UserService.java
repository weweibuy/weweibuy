package com.weweibuy.webuy.user.service;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.webuy.user.common.model.po.WebuyUser;
import com.weweibuy.webuy.user.common.model.po.WebuyUserExample;
import com.weweibuy.webuy.user.model.form.RegisterForm;
import com.weweibuy.webuy.user.service.base.BaseCrudService;

/**
 * @ClassName UserService
 * @Description
 * @Author durenhao
 * @Date 2018/11/25 17:06
 **/
public interface UserService extends BaseCrudService<WebuyUser, WebuyUserExample>{

    CommonDataResponse sendVerificationCode(String phoneNum);

    CommonDataResponse registerUser(RegisterForm registerForm);

    CommonDataResponse checkAccountExist(String phoneNum);

    CommonDataResponse loadUserByUsername(String username) throws Exception;
}
