package com.weweibuy.auth.authorization;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义授权成功的跳转页面；  不设置的话跳转到之前的请求页面
 * @ClassName IAuthenticationSuccessHandler
 * @Description
 * @Author durenhao
 * @Date 2018/12/7 22:27
 **/
@Component("iAuthenticationSuccessHandler") // 需要将其配置到
public class IAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
    // 可以自定义 响应信息

    }
}
