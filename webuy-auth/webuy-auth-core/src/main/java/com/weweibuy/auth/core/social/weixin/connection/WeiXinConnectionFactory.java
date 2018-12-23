package com.weweibuy.auth.core.social.weixin.connection;

import com.weweibuy.auth.core.social.weixin.api.WeiXin;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * @ClassName WeiXinConnectionFactory
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 23:09
 **/
public class WeiXinConnectionFactory extends OAuth2ConnectionFactory<WeiXin> {

    public WeiXinConnectionFactory(String providerId, OAuth2ServiceProvider<WeiXin> serviceProvider) {
        super(providerId, serviceProvider, new WeiXinApiAdapter());
    }
}
