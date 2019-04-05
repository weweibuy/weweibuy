package com.weweibuy.webuy.auth.core.social.qq.provider;

import com.weweibuy.webuy.auth.core.social.qq.api.QQ;
import com.weweibuy.webuy.auth.core.social.qq.api.impl.QQimpl;
import com.weweibuy.webuy.auth.core.social.qq.operation.QQOperations;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * qq登录的ServiceProvider 提供api给connectFactory，
 * @ClassName QQServiceProvider
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 10:58
 **/
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    /** 通过app_id 获取授权码的地址 */
    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    /** 通过 授权码换取 access_token 的地址 */
    private static final String URL_ACCESSTOKEN = "https://graph.qq.com/oauth2.0/token";

    private String appId;

    public QQServiceProvider(String appId, String appSecurity) {
        super(new QQOperations(appId, appSecurity, URL_AUTHORIZE, URL_ACCESSTOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String access_token) {
        return new QQimpl(access_token, appId);
    }
}
