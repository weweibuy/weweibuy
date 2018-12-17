package com.weweibuy.auth.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 定义验证码处理逻辑
 * @ClassName ValidateCodeProcessor
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 9:52
 **/
public interface ValidateCodeProcessor {

    String SESSION_PREFIX = "AUTH:VALIDATE:CODE:";

    void create(ServletWebRequest request);

    void validate(ServletWebRequest request);


}
