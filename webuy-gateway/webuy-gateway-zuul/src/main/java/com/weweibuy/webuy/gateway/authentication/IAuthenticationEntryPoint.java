package com.weweibuy.webuy.gateway.authentication;

import com.alibaba.fastjson.JSONObject;
import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.gateway.eum.ResourcesWebMsg;
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
        log.error(authException.getMessage());
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json;charset=utf-8");
        Throwable cause = authException.getCause();
        if(cause instanceof InvalidTokenException){
            CommonJsonResponse fail = CommonJsonResponse.fail(ResourcesWebMsg.NEED_LOGIN);
            String jsonString = JSONObject.toJSONString(fail);
            response.getWriter().write(jsonString);
        }else {
            CommonJsonResponse fail = CommonJsonResponse.fail(ResourcesWebMsg.TOKEN_INVALID);
            String jsonString = JSONObject.toJSONString(fail);
            response.getWriter().write(jsonString);
        }


    }
}
