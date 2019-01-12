package com.weweibuy.gateway.authentication.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * cookie中的Authentication失效的异常
 * @ClassName CookieAuthenticationInvalidException
 * @Description
 * @Author durenhao
 * @Date 2019/1/12 21:42
 **/
public class CookieAuthenticationInvalidException extends AuthenticationException {

    public CookieAuthenticationInvalidException(String msg, Throwable t) {
        super(msg, t);
    }


    public CookieAuthenticationInvalidException(String msg) {
        super(msg);
    }
}
