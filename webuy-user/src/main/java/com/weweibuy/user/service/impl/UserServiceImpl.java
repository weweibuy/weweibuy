package com.weweibuy.user.service.impl;

import com.weweibuy.user.eum.UserWebMsgEum;
import com.weweibuy.user.mapper.WebuyUserMapper;
import com.weweibuy.user.model.dto.UserWebResult;
import com.weweibuy.user.model.po.WebuyUser;
import com.weweibuy.user.model.po.WebuyUserExample;
import com.weweibuy.user.service.UserService;
import com.weweibuy.user.service.impl.base.BaseCrudServiceImpl;
import com.weweibuy.user.utils.CodeUtil;
import com.weweibuy.user.utils.VerificationCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public UserWebResult sendVerificationCode(String phoneNum) {
        if(VerificationCodeUtil.canSendPhoneVerifyCode(phoneNum)){
            VerificationCodeUtil.sendVerificationCode(phoneNum);
            return UserWebResult.success();
        }
        return UserWebResult.fail(UserWebMsgEum.GET_VERIFICATION_CODE_TOO_FREQUENT);
    }

    @Override
    public UserWebResult registerUser(String phone, String pwd) {
        WebuyUser user = new WebuyUser();
        user.setPhone(phone);
        user.setPassword(CodeUtil.getStrMD5(pwd));
        int i = userMapper.insertSelective(user);
        if(i > 0){
            return UserWebResult.success();
        }
        return UserWebResult.fail(UserWebMsgEum.DO_NOT_RESUBMIT);
    }

    /**
     * 验证账号是否存在
     * @param phoneNum 手机号
     * @return
     */
    @Override
    public UserWebResult checkAccountExist(String phoneNum) {
        WebuyUserExample example = new WebuyUserExample();
        example.createCriteria().andPhoneEqualTo(phoneNum);
        List<WebuyUser> userList = userMapper.selectByExample(example);
        if(userList == null || userList.size() > 0){
            return UserWebResult.fail();
        }
        return UserWebResult.success();
    }
}
