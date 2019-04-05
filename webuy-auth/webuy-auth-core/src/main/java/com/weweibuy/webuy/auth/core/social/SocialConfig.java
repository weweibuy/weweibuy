package com.weweibuy.webuy.auth.core.social;

import com.weweibuy.webuy.auth.core.config.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 社交登录配置
 * @ClassName SocialConfig
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 11:48
 **/
@Configuration
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;

    /**
     * 配置用户信息的存储方式，默认使用的InMemory
     * @param connectionFactoryLocator
     * @return
     */
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        InMemoryUsersConnectionRepository connectionRepository = new InMemoryUsersConnectionRepository(connectionFactoryLocator);
        if(connectionSignUp != null){
            connectionRepository.setConnectionSignUp(connectionSignUp);
        }
        return connectionRepository;
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Bean
    public SpringSocialConfigurer iSpringSocialConfigurer(){
        ISpringSocialConfigurer configurer = new ISpringSocialConfigurer(securityProperties.getSocial().getQq().getProcessesUrl());
        /* TODO
         这个这会在connectionSignUp没有实现类时有用
         SpringSecurity 需要从session中获取社交用户信息, 但在通过用户模块获取到保持在auth模块中的信息以后需要考虑
        */
        configurer.signupUrl("/user/signup");
        return configurer;
    }

    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator){
        return new ProviderSignInUtils(connectionFactoryLocator, getUsersConnectionRepository(connectionFactoryLocator));
    }

}
