package com.weweibuy.webuy.auth.core.social.weixin.provider;

import com.weweibuy.webuy.auth.core.social.weixin.api.WeiXin;
import com.weweibuy.webuy.auth.core.social.weixin.api.impl.WeiXinImpl;
import com.weweibuy.webuy.auth.core.social.weixin.operation.WeiXinOperations;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * 微信的serviceProvider
 * @ClassName WeiXinProvider
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 22:31
 **/
public class WeiXinProvider extends AbstractOAuth2ServiceProvider<WeiXin> {

    // https://open.weixin.qq.com/connect/qrconnect?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
    /** 通过app_id 获取授权码的地址 */
    private static final String URL_AUTHORIZE = "https://open.weixin.qq.com/connect/qrconnect";

    // https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
    /** 通过 授权码换取 access_token 的地址 */
    private static final String URL_ACCESSTOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";


    public WeiXinProvider(String appId, String appSecurity) {
        super(new WeiXinOperations(appId, appSecurity, URL_AUTHORIZE, URL_ACCESSTOKEN));
    }

    @Override
    public WeiXin getApi(String access_token) {
        return new WeiXinImpl(access_token);
    }
}
