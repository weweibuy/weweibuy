package com.weweibuy.gateway.authentication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 资源服务器处理AccessDeniedException(未认证,权限不足,拒绝访问)
 * 已经其他的异常(如token过期)
 * @ClassName IAuthenticationEntryPoint
 * @Description
 * @Author durenhao
 * @Date 2019/1/4 22:18
 **/
@Slf4j
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
        String accept = request.getHeader("Accept");
        log.error(authException.getMessage());
        if(accept.contains("text/html")){
            response.sendRedirect("/auth/webuy-login.html");
        }else {
            response.setContentType("application/json;charset=utf-8");
            Throwable cause = authException.getCause();
            if(cause instanceof InvalidTokenException){
                response.getWriter().write("token 过期");
            }else {
                response.getWriter().write("认证失败");
            }

        }

    }
}
