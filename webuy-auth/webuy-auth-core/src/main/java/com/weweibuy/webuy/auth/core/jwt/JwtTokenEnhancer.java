package com.weweibuy.webuy.auth.core.jwt;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * jwttoken 增强器，用于在jwt中写入增加字段
 * @ClassName JwtTokenEnhancer
 * @Description
 * @Author durenhao
 * @Date 2018/12/30 19:01
 **/
public class JwtTokenEnhancer implements TokenEnhancer {

    /**
     * 设置accessToken的增强信息；需要配置到endpoints 中生效
     * @param accessToken
     * @param authentication
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "test");
        // 设附加信息(自己定义的字段)
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(map);
        return accessToken;
    }
}
