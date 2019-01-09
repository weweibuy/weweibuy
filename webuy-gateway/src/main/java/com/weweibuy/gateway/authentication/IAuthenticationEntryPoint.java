package com.weweibuy.gateway.authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "security.oauth2.client")
public class IAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Value("${user-authorization-uri}")
    private String userAuthorizationUri;

    @Value("${client-id}")
    private String clientId;


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // http://localhost/oauth/authorize?client_id=webuy&redirect_uri=http://localhost:8201/login&response_type=code&state=OsxohM'
//        String s = userAuthorizationUri + "?" + "client_id=%s&redirect_uri=%s&response_type=code&state=OsxohM";
//        String url = String.format(s, clientId, request.getRequestURI());
        response.sendRedirect("/auth/webuy-login.html");
    }
}
