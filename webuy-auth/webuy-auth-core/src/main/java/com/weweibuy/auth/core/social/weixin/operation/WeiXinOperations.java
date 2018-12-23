package com.weweibuy.auth.core.social.weixin.operation;

import com.alibaba.fastjson.JSONObject;
import com.weweibuy.auth.core.model.vo.WeiXinTokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * @ClassName WeiXinOperations
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 23:29
 * TODO 关于封装发送请求获取token
 **/
@Slf4j
public class WeiXinOperations extends OAuth2Template {

    public WeiXinOperations(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
        setUseParametersForClientAuthentication(true);
    }

    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        // access_token=FE04************************CCE2&expires_in=7776000&refresh_token=88E4************************BE14
        String result = getRestTemplate().postForObject(accessTokenUrl, parameters, String.class);
        if(result.contains("errcode") || result.contains("errmsg")){
            log.error("换取token失败, 响应的结果{}", result);
            throw new RestClientException("换取token失败");
        }
        WeiXinTokenResponse tokenResponse = JSONObject.parseObject(result, WeiXinTokenResponse.class);
        return new WeiXinAccessGrant(tokenResponse.getAccess_token(), tokenResponse.getScope(), tokenResponse.getRefresh_token(),
                tokenResponse.getExpires_in(), tokenResponse.getOpenid());
    }

    @Override
    public AccessGrant exchangeForAccess(String authorizationCode, String redirectUri, MultiValueMap<String, String> additionalParameters) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap();

        params.set("appid", super.clientId);
        params.set("client_secret", this.clientSecret);

        params.set("code", authorizationCode);
        params.set("redirect_uri", redirectUri);
        params.set("grant_type", "authorization_code");
        if(additionalParameters != null) {
            params.putAll(additionalParameters);
        }

        return this.postForAccessGrant(this.accessTokenUrl, params);
    }

    public AccessGrant refreshAccess(String refreshToken, MultiValueMap<String, String> additionalParameters) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        if(this.useParametersForClientAuthentication) {
            params.set("client_id", this.clientId);
            params.set("client_secret", this.clientSecret);
        }

        params.set("refresh_token", refreshToken);
        params.set("grant_type", "refresh_token");
        if(additionalParameters != null) {
            params.putAll(additionalParameters);
        }

        return this.postForAccessGrant(this.accessTokenUrl, params);
    }


    /**
     * 微信返回的contentType是html/text，添加相应的HttpMessageConverter来处理。
     */
    protected RestTemplate createRestTemplate() {
        RestTemplate restTemplate = super.createRestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;
    }

}
