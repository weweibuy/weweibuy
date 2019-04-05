package com.weweibuy.webuy.auth.core.social.qq.operation;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * Operations 处理根据认证码换取token逻辑
 * @ClassName QQOperations
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 17:53
 **/
@Slf4j
public class QQOperations extends OAuth2Template {


    public QQOperations(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
        setUseParametersForClientAuthentication(true);
    }

    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        // access_token=FE04************************CCE2&expires_in=7776000&refresh_token=88E4************************BE14
        String result = getRestTemplate().postForObject(accessTokenUrl, parameters, String.class);
        if(result.contains("code") && result.contains("msg")){
            log.error("换取token失败, 响应的结果{}", result);
            throw new RestClientException("换取token失败");
        }
        String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(result, "&");

        String accessToken = StringUtils.substringAfterLast(items[0], "=");
        Long expiresIn = new Long(StringUtils.substringAfterLast(items[1], "="));
        String refreshToken = StringUtils.substringAfterLast(items[2], "=");
        return new AccessGrant(accessToken, null, refreshToken, expiresIn);
    }

    @Override
    protected RestTemplate createRestTemplate(){
        RestTemplate restTemplate = super.createRestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;
    }

}
