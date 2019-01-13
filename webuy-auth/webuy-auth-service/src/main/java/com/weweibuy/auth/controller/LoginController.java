package com.weweibuy.auth.controller;

import com.weweibuy.auth.security.IAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录控制器
 * @ClassName LoginController
 * @Description
 * @Author durenhao
 * @Date 2019/1/12 22:54
 **/
@Controller
public class LoginController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    private IAuthenticationSuccessHandler authenticationSuccessHandler;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        requestCache.saveRequest(request, response);
        return "/webuy-login.html";
    }

}
