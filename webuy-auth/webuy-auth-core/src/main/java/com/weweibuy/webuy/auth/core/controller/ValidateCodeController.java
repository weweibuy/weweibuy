package com.weweibuy.webuy.auth.core.controller;

import com.weweibuy.webuy.auth.core.validate.code.impl.SmsValidateCodeProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName ValidateCodeController
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 13:35
 **/
@RestController
@Slf4j
public class ValidateCodeController {

    @Autowired
    private SmsValidateCodeProcessor smsValidateCodeProcessor;

    @GetMapping("/code/sms")
    public void getValidateCode(String mobile, HttpServletRequest request, HttpServletResponse response){
        log.info("手机号码：{}", mobile);
        smsValidateCodeProcessor.create(new ServletWebRequest(request, response));
    }

}
