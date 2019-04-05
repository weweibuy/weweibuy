package com.weweibuy.webuy.auth.core.social.qq.api.impl;

import com.weweibuy.webuy.auth.core.model.vo.QQUserInfo;
import com.weweibuy.webuy.auth.core.social.qq.api.QQ;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * Oauth2 API 的实现
 * @ClassName QQimpl
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 9:54
 **/
@Data
public class QQimpl extends AbstractOAuth2ApiBinding implements QQ {

    /** qq登录获取OpenId 地址 */
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    // https://graph.qq.com/user/get_user_info?access_token=*************&
    // oauth_consumer_key=12345& openid=****************
    // 这里的参数access_token Auth2会帮我们封装并发送请求，只需提供oauth_consumer_key与openid
    /** 社交登录获取QQ用户信息的URL */
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?" +
                "oauth_consumer_key=%s&openid=%s";

    /** appid 与 oauth_consumer_key 对应*/
    private String appId;

    /** QQ号码 */
    private String openId;

    // access_token  父类已经提供

    /**
     * 根据access_token 和 oauth_consumer_key 封装QQimpl对象
     * 并调用父类方法获取openid
     * @param access_token
     * @param appId
     */
    public QQimpl(String access_token, String appId){
        // 因为AbstractOAuth2ApiBinding会默认将 access_token 以请求头的形式发出请求头
        // TokenStrategy.OAUTH_TOKEN_PARAMETER 指定access_token 以参数形式发出
        super(access_token, TokenStrategy.OAUTH_TOKEN_PARAMETER);

        //callback( {"client_id":"YOUR_APPID","openid":"YOUR_OPENID"} );
        String result = getRestTemplate().getForObject(String.format(URL_GET_OPENID, access_token), String.class);

        this.appId = appId;

        this.openId = StringUtils.substringBetween("\"openid\":\"", "\"}");

    }

    @Override
    public QQUserInfo getUserInfo() {
        QQUserInfo userInfo = getRestTemplate().getForObject(String.format(URL_GET_USERINFO, appId, openId), QQUserInfo.class);
        userInfo.setOpenId(this.openId);
        return userInfo;
    }


}
