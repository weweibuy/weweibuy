package com.weweibuy.auth.core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @ClassName ValidateCodeException
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 10:57
 **/
public class ValidateCodeException extends AuthenticationException {


    public ValidateCodeException(String msg){
        super(msg);
    }


}
