package com.weweibuy.auth.security;

import com.alibaba.fastjson.JSONObject;
import com.weweibuy.auth.core.config.eum.LoginResponseType;
import com.weweibuy.auth.core.config.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功的处理方法
 * @ClassName IAuthenticationSuccessHandler
 * @Description
 * @Author durenhao
 * @Date 2018/12/15 20:02
 **/
@Component
public class IAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        // authentication 包装这用户的信息
        if(LoginResponseType.JSON.equals(securityProperties.getLoginResponseType())){
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(JSONObject.toJSONString(authentication));
        }else {
            super.onAuthenticationSuccess(httpServletRequest,  httpServletResponse, authentication);
        }

    }
}
