package com.weweibuy.webuy.auth.core.social.qq.config;


import com.weweibuy.webuy.auth.core.config.properties.QQProperties;
import com.weweibuy.webuy.auth.core.config.properties.SecurityProperties;
import com.weweibuy.webuy.auth.core.social.qq.connection.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @ClassName QQConfig
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 12:06
 **/
@Configuration
@ConditionalOnProperty(prefix = "webuy.security.social.qq", name = "app-id")
public class QQConfig extends SocialConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer configurer,
                                       Environment environment) {
        configurer.addConnectionFactory(createConnectionFactory());
    }

    public ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqProperties = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqProperties.getProviderId(), qqProperties.getAppId(),
                qqProperties.getAppSecurity());
    }


}
