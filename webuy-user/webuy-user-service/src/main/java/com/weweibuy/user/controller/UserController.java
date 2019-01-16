package com.weweibuy.user.controller;

import com.weweibuy.user.eum.UserWebMsgEum;
import com.weweibuy.user.model.dto.UserWebResult;
import com.weweibuy.user.service.UserService;
import com.weweibuy.user.utils.RSAUtil;
import com.weweibuy.user.utils.VerificationCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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
@RequestMapping(value = "/user", produces="application/json;charset=UTF-8")
@Validated  // 如果对单个参数验证这个注解要加载类上
@Api(value = "用户接口")
public class UserController {

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
    @GetMapping("/verificationCode/{phoneNum}")
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


    @PostMapping("/register")
    @ApiOperation(value = "注册用户")
    public UserWebResult registerUser(@ApiParam(required = true) String phone,
                                      @ApiParam(value = "密码与验证码通过逗号凭借并加密数据", required = true) String pwdData) throws Exception {
        if(StringUtils.isBlank(phone) || StringUtils.isBlank(pwdData)){
            return UserWebResult.fail(UserWebMsgEum.USERNAME_OR_PWD_NOT_NULL);
        }
        byte[] bytes = RSAUtil.decryptByPrivateKey(pwdData, PRIVATE_KEY);
        String data = new String(bytes);
        String[] split = data.split(",");
        if(split.length != 2){
            return UserWebResult.paramWrong();
        }
        if(!split[1].trim().equals(VerificationCodeUtil.getVerificationCode(phone))){
            return UserWebResult.fail(UserWebMsgEum.VERIFICATION_CODE_WRONG);
        }
        return userService.registerUser(phone, split[0]);
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
