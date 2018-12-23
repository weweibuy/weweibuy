package com.weweibuy.auth.core.social.weixin.api.impl;

import com.weweibuy.auth.core.model.vo.WeiXinUserInfo;
import com.weweibuy.auth.core.social.weixin.api.WeiXin;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 获取微信用户信息
 * @ClassName WeiXinImpl
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 22:23
 **/
public class WeiXinImpl extends AbstractOAuth2ApiBinding implements WeiXin {

    // https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
    /**
     * 微信在使用code换token是会直接返回 openid
     */
    private static final String URL_GET_OPENID = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    // https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID
    private final String URL_GET_USERINFO = "https://api.weixin.qq.com/sns/userinfo?openid=%s";

    public WeiXinImpl(String access_token){
        super(access_token, TokenStrategy.OAUTH_TOKEN_PARAMETER);
    }

    @Override
    public WeiXinUserInfo getWeiXinUserInfo(String openId) {
        WeiXinUserInfo userInfo = getRestTemplate().getForObject(String.format(URL_GET_USERINFO, openId), WeiXinUserInfo.class);
        userInfo.setOpenid(openId);
        return userInfo;
    }

    /**
     * 由于父类使用的restTemplate 的StringHttpMessageConverter使用的ISO 8859编码
     * 微信接受的是UTF-8
     * @return
     */
    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
        messageConverters.remove(0);
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return messageConverters;
    }
}
