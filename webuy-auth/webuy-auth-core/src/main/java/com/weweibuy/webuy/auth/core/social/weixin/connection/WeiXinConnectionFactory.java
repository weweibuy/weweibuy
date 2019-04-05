package com.weweibuy.webuy.auth.core.social.weixin.connection;

import com.weweibuy.webuy.auth.core.social.weixin.api.WeiXin;
import com.weweibuy.webuy.auth.core.social.weixin.operation.WeiXinAccessGrant;
import com.weweibuy.webuy.auth.core.social.weixin.provider.WeiXinProvider;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.support.OAuth2Connection;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * @ClassName WeiXinConnectionFactory
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 23:09
 **/
public class WeiXinConnectionFactory extends OAuth2ConnectionFactory<WeiXin> {

    public WeiXinConnectionFactory(String providerId, String appId, String appSecurity) {
        super(providerId, new WeiXinProvider(appId, appSecurity), new WeiXinApiAdapter());
    }

    @Override
    public Connection<WeiXin> createConnection(AccessGrant accessGrant) {
        return new OAuth2Connection<WeiXin>(getProviderId(), extractProviderUserId(accessGrant), accessGrant.getAccessToken(),
                accessGrant.getRefreshToken(), accessGrant.getExpireTime(), getOAuth2ServiceProvider(), getApiAdapter());
    }

    @Override
    public Connection<WeiXin> createConnection(ConnectionData data) {
        return new OAuth2Connection<WeiXin>(data, getOAuth2ServiceProvider(), getApiAdapter(data.getProviderId()));
    }

    /**
     * 获取openid
     * @param accessGrant
     * @return
     */
    @Override
    protected String extractProviderUserId(AccessGrant accessGrant) {
        if(accessGrant instanceof WeiXinAccessGrant){
            WeiXinAccessGrant weiXinAccessGrant = (WeiXinAccessGrant) accessGrant;
            return weiXinAccessGrant.getOpenid();
        }
        return null;
    }

    private OAuth2ServiceProvider<WeiXin> getOAuth2ServiceProvider() {
        return (OAuth2ServiceProvider<WeiXin>) getServiceProvider();
    }

    /**
     * 这里的WeiXinApiAdapter是多实例的；为了传递openid给WeiXinImpl
     * @param providerUserId
     * @return
     */
    protected ApiAdapter<WeiXin> getApiAdapter(String providerUserId) {
        return new WeiXinApiAdapter(providerUserId);
    }



}
