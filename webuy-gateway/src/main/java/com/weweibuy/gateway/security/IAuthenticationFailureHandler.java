package com.weweibuy.gateway.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 授权失败处理
 * @ClassName IAuthenticationSuccessHandler
 * @Description
 * @Author durenhao
 * @Date 2018/12/7 22:46
 **/
@Component("iAuthenticationFailureHandler")
public class IAuthenticationFailureHandler implements AuthenticationFailureHandler {
                                        // extends SimpleUrlAuthenticationFailureHandler  super.onAuthenticationFailure 返回默认错误页面
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

    }
}
