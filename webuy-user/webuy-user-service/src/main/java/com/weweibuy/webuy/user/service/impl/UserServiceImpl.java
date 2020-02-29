package com.weweibuy.webuy.user.service.impl;

import com.weweibuy.webuy.common.model.dto.CommonDataJsonResponse;
import com.weweibuy.webuy.common.model.eum.CommonResponseEum;
import com.weweibuy.webuy.user.common.model.po.WebuyUser;
import com.weweibuy.webuy.user.common.model.po.WebuyUserExample;
import com.weweibuy.webuy.user.mapper.WebuyUserMapper;
import com.weweibuy.webuy.user.model.form.RegisterForm;
import com.weweibuy.webuy.user.service.UserService;
import com.weweibuy.webuy.user.service.impl.base.BaseCrudServiceImpl;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private WebuyUserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public CommonDataJsonResponse sendVerificationCode(String phoneNum) {
        Message message = MessageBuilder.withBody(phoneNum.getBytes())
                .setCorrelationId("12134")
                .build();
        // 这里使用 convertAndSend CorrelationId 才有效
        // convertSendAndReceive CorrelationId 是Spring AMQP 自动弄的自增
        // TODO  convertAndSend 与 convertSendAndReceive 区别！！！
        rabbitTemplate.convertAndSend("user_sms_code", "", message);
        return CommonDataJsonResponse.success(null);
    }

    @Override
    @Transactional
    public CommonDataJsonResponse registerUser(RegisterForm registerForm) {
        WebuyUser user = new WebuyUser();
        WebuyUserExample example = new WebuyUserExample();
        example.createCriteria().andUsernameEqualTo(registerForm.getUsername());
        List<WebuyUser> webuyUsers = userMapper.selectByExample(example);
        if(webuyUsers != null && webuyUsers.size() > 0){
            return CommonDataJsonResponse.response(CommonResponseEum.BAD_REQUEST_PARAM, null);
        }
        user.setUsername(registerForm.getUsername());
        user.setPhone(registerForm.getPhone());
        user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        int i = userMapper.insertSelective(user);
        if(i > 0){
            return CommonDataJsonResponse.success(null);
        }
        return CommonDataJsonResponse.response(CommonResponseEum.BAD_REQUEST_PARAM, null);
    }

    /**
     * 验证账号是否存在
     * @param phoneNum 手机号
     * @return
     */
    @Override
    public CommonDataJsonResponse checkAccountExist(String phoneNum) {
        WebuyUserExample example = new WebuyUserExample();
        example.createCriteria().andPhoneEqualTo(phoneNum);
        List<WebuyUser> userList = userMapper.selectByExample(example);
        if(userList == null || userList.size() > 0){
            return CommonDataJsonResponse.response(CommonResponseEum.BAD_REQUEST_PARAM, null);
        }
        return CommonDataJsonResponse.success(null);
    }

    @Override
    public CommonDataJsonResponse loadUserByUsername(String username) throws Exception {
        WebuyUserExample example = new WebuyUserExample();
        WebuyUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<WebuyUser> webuyUsers = userMapper.selectByExample(example);
        if(webuyUsers == null || webuyUsers.size() == 0){
            return CommonDataJsonResponse.response(CommonResponseEum.BAD_REQUEST_PARAM, null);
        }
        WebuyUser webuyUser = webuyUsers.get(0);
        return CommonDataJsonResponse.success(webuyUser);
    }
}
