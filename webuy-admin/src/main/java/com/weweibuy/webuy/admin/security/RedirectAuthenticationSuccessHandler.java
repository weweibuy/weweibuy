package com.weweibuy.webuy.admin.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName RedirectAuthenticationSuccessHandler
 * @Description
 * @Author durenhao
 * @Date 2019/4/5 18:56
 **/
@AllArgsConstructor
public class RedirectAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final String redirectUrl;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.sendRedirect(redirectUrl);
    }
}
