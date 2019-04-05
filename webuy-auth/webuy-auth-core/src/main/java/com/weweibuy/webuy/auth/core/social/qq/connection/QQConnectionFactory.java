package com.weweibuy.webuy.auth.core.social.qq.connection;

import com.weweibuy.webuy.auth.core.social.qq.api.QQ;
import com.weweibuy.webuy.auth.core.social.qq.provider.QQServiceProvider;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @ClassName QQConnectionFactory
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 11:44
 **/
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectionFactory(String providerId, String appId, String appSecurity) {
        super(providerId, new QQServiceProvider(appId, appSecurity), new QQApiAdapter());
    }
}
