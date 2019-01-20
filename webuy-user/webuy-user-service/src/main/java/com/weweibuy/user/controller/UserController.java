package com.weweibuy.user.controller;

import com.weweibuy.dto.CommonJsonResponse;
import com.weweibuy.support.client.SmsCodeClient;
import com.weweibuy.user.common.eum.UserWebMsgEum;
import com.weweibuy.user.common.model.dto.UserWebResult;
import com.weweibuy.user.model.form.RegisterForm;
import com.weweibuy.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description
 * @Author durenhao
 * @Date 2018/11/25 11:15
 **/
@PropertySource("classpath:config/key/key.properties")
@RestController
@RequestMapping(produces="application/json;charset=UTF-8")
@Validated  // 如果对单个参数验证这个注解要加载类上
@Api(value = "用户接口")
public class UserController {

    @Autowired
    @Lazy
    private SmsCodeClient smsCodeClient;

    @Autowired
    private UserService userService;

    @Value("${key.public_key}")
    private  String PUBLIC_KEY;

    @Value("${key.private_key}")
    private String PRIVATE_KEY;

    /**
     * 根据手机号获取验证码
     * @param
     * @return
     */
    @GetMapping("/register/verificationCode/{phoneNum}")
    @ApiOperation(value = "获取验证码", notes = "1分钟获取一次验证码")
    public UserWebResult sendVerificationCode(@PathVariable  String phoneNum){
        if(phoneNum == null || !phoneNum.matches("^[1][3,4,5,7,8][0-9]{9}$")){
            return UserWebResult.fail(UserWebMsgEum.PHONE_NUM_PATTERN_WRONG);
        }
        return userService.sendVerificationCode(phoneNum);
    }

    @GetMapping("/checkAccountExist/{phoneNum}")
    @ApiOperation(value = "检测手机号对应账号是否存在")
    public UserWebResult checkAccountExist(@PathVariable String phoneNum){
        if(StringUtils.isBlank(phoneNum)){
            return UserWebResult.paramBlank();
        }
        return userService.checkAccountExist(phoneNum);
    }


    @PostMapping("/register/signUp")
    @ApiOperation(value = "注册用户")
    public UserWebResult registerUser(RegisterForm registerForm, BindingResult result) throws Exception {
        if(result.hasErrors()){
            return UserWebResult.fail(UserWebMsgEum.USERNAME_OR_PWD_NOT_NULL);
        }

        CommonJsonResponse<String> smsCode = smsCodeClient.getSmsCode(registerForm.getUsername());
        String code = smsCode.getData();
        if(StringUtils.isBlank(code) || !code.equals(registerForm.getCode())){
            return UserWebResult.fail(UserWebMsgEum.VERIFICATION_CODE_WRONG);
        }
        return userService.registerUser(registerForm.getUsername(), registerForm.getPassword());
    }


    /**
     * 提供给权限服务的加载用户信息的接口
     * @return
     */
    @GetMapping("/loadUserByUsername")
    @ApiOperation(value = "提供给权限服务的加载用户信息")
    public UserWebResult loadUserByUsername(@ApiParam(required = true) String username) throws Exception {
        if(StringUtils.isBlank(username)){
            return UserWebResult.fail("用户名密码不能为空");
        }
        UserWebResult webResult = userService.loadUserByUsername(username);
        return webResult;

    }


}
