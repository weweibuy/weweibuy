package com.weweibuy.user.service.impl;

import com.weweibuy.dto.WebResult;
import com.weweibuy.user.mapper.WebuyUserMapper;
import com.weweibuy.user.model.po.WebuyUser;
import com.weweibuy.user.model.po.WebuyUserExample;
import com.weweibuy.user.service.UserService;
import com.weweibuy.user.service.impl.base.BaseCrudServiceImpl;
import com.weweibuy.user.utils.VerificationCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author durenhao
 * @Date 2018/11/25 17:07
 **/
@Service
public class UserServiceImpl extends BaseCrudServiceImpl<WebuyUser, WebuyUserExample> implements UserService {

    @Autowired
    private WebuyUserMapper userMapper;

    public WebResult sendVerificationCode(String phoneNum) {
        if(VerificationCodeUtil.canSendPhoneVerifyCode(phoneNum)){
            VerificationCodeUtil.sendVerificationCode(phoneNum);
            return WebResult.success("已发送");
        }
        return WebResult.fail("请稍后再试");
    }

    @Override
    public WebResult registerUser(String phone, String pwd) {
        WebuyUser user = new WebuyUser();
        user.setPhone(phone);
        user.setPassword(pwd);
        int i = userMapper.insertSelective(user);
        if(i > 0){
            return WebResult.success();
        }
        return WebResult.fail("请勿重复注册");
    }
}
