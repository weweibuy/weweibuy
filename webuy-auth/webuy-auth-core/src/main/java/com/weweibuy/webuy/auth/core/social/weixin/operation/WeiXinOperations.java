package com.weweibuy.webuy.auth.core.social.weixin.operation;

import com.alibaba.fastjson.JSONObject;
import com.weweibuy.webuy.auth.core.model.vo.WeiXinTokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Parameters;
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

    private String clientId;

    private String clientSecret;

    private String authorizeUrl;

    private String accessTokenUrl;

    public WeiXinOperations(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authorizeUrl = authorizeUrl;
        this.accessTokenUrl = accessTokenUrl;
        setUseParametersForClientAuthentication(true);
    }



    @Override
    public AccessGrant exchangeForAccess(String authorizationCode, String redirectUri, MultiValueMap<String, String> additionalParameters) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        /*
        appid	是	应用唯一标识，在微信开放平台提交应用审核通过后获得
        secret	是	应用密钥AppSecret，在微信开放平台提交应用审核通过后获得
        code	是	填写第一步获取的code参数
        grant_type	是	填authorization_code
        */

        params.set("appid", this.clientId);
        params.set("secret", this.clientSecret);
        params.set("code", authorizationCode);
        params.set("grant_type", "authorization_code");
        if(additionalParameters != null) {
            params.putAll(additionalParameters);
        }

        return this.postForAccessGrant(this.accessTokenUrl, params);
    }

    public AccessGrant refreshAccess(String refreshToken, MultiValueMap<String, String> additionalParameters) {
        /*
        appid	是	应用唯一标识
        grant_type	是	填refresh_token
        refresh_token	是	填写通过access_token获取到的refresh_token参数
         */
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        params.set("appid", this.clientId);
        params.set("refresh_token", refreshToken);
        params.set("grant_type", "refresh_token");
        if(additionalParameters != null) {
            params.putAll(additionalParameters);
        }
        return this.postForAccessGrant(this.accessTokenUrl, params);
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

    /**
     * 构建获取授权码的请求。也就是引导用户跳转到微信的地址。
     */
    @Override
    public String buildAuthenticateUrl(OAuth2Parameters parameters) {
        String url = super.buildAuthenticateUrl(parameters);
        url = url + "&appid=" + this.clientId+"&scope=snsapi_login";
        return url;
    }

    @Override
    public String buildAuthorizeUrl(OAuth2Parameters parameters) {
        /*appid	是	应用唯一标识
            redirect_uri	是	请使用urlEncode对链接进行处理
            response_type	是	填code
            scope	是	应用授权作用域，拥有多个作用域用逗号（,）分隔，网页应用目前仅填写snsapi_login即
            state	否	用于保持请求和回调的状态，授权请求后原样带回给第三方。
            该参数可用于防止csrf攻击（跨站请求伪造攻击），建议第三方带上该参数，可设置为简单的随机数加session进行校验
        */
        return buildAuthenticateUrl(parameters);
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
