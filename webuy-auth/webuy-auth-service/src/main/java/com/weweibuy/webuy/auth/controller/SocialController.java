package com.weweibuy.webuy.auth.controller;

import com.weweibuy.webuy.auth.core.model.vo.SocialUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName SocialController
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 21:09
 **/
@RestController("/social")
public class SocialController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    /**
     * 请求获取社交登录的用户信息
     * @param request
     * @return
     */
    @GetMapping("/user")
    public SocialUserInfo getSocialUserInfo(HttpServletRequest request){
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        SocialUserInfo socialUserInfo = new SocialUserInfo();
        ConnectionKey connectionKey = connection.getKey();
        socialUserInfo.setProviderId(connectionKey.getProviderId()); // 服务提供商名
        socialUserInfo.setProviderUserId(connectionKey.getProviderUserId()); // openid
        socialUserInfo.setNickname(connection.getDisplayName());
        socialUserInfo.setHeadimg(connection.getImageUrl());
        return socialUserInfo;
    }

}
