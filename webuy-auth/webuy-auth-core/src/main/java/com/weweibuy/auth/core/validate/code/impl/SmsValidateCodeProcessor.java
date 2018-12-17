package com.weweibuy.auth.core.validate.code.impl;

import com.weweibuy.auth.core.config.constants.SecurityConstants;
import com.weweibuy.auth.core.model.vo.ValidateCode;
import com.weweibuy.auth.core.validate.code.AbstractValidateCodeProcessor;
import com.weweibuy.auth.core.validate.code.SmsValidateCodeSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName SmsValidateCodeProcessor
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 12:22
 **/
@Slf4j
@Component
public class SmsValidateCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    @Autowired
    private SmsValidateCodeSender smsValidateCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) {
        smsValidateCodeSender.send(request.getParameter(SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_MOBILE), validateCode.getCode());
    }
}
