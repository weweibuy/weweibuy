package com.weweibuy.user.controller;

import com.weweibuy.dto.WebResult;
import com.weweibuy.user.service.UserService;
import com.weweibuy.user.utils.RSAUtil;
import com.weweibuy.user.utils.VerificationCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/user")
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
    public WebResult sendVerificationCode(@PathVariable  String phoneNum){
        if(phoneNum == null || !phoneNum.matches("^[1][3,4,5,7,8][0-9]{9}$")){
            return WebResult.fail("手机号码格式错误");
        }
        return userService.sendVerificationCode(phoneNum);
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册用户")
    public WebResult registerUser(String phone, String pwdData) throws Exception {
        if(StringUtils.isBlank(phone) || StringUtils.isBlank(pwdData)){
            return WebResult.fail("用户名或密码不能为空");
        }
        byte[] bytes = RSAUtil.decryptByPrivateKey(pwdData, PRIVATE_KEY);
        String data = new String(bytes);
        String[] split = data.split(",");
        if(split.length != 2){
            return WebResult.fail("输入参数错误");
        }
        if(!split[1].trim().equals(VerificationCodeUtil.getVerificationCode(phone))){
            return WebResult.fail("验证码错误");
        }
        return userService.registerUser(phone, split[0]);
    }



}
