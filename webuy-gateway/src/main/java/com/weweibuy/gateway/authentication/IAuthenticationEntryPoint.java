package com.weweibuy.gateway.authentication;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 资源服务器处理AccessDeniedException(权限不足,拒绝访问)
 * OAUTH有默认的处理 OAuth2AuthenticationEntryPoint 直接返回xml页面
 * 在这里重定向到登录页
 * @ClassName IAuthenticationEntryPoint
 * @Description
 * @Author durenhao
 * @Date 2019/1/4 22:18
 **/
@Component
public class IAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.sendRedirect("/auth/webuy-login.html");
    }
}
