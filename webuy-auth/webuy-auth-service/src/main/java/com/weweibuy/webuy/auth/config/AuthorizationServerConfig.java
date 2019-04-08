package com.weweibuy.webuy.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * oauth2 认证配置
 * @ClassName AppAuthorizationServerConfig
 * @Description
 * @Author durenhao
 * @Date 2018/12/30 14:01
 **/
@Configuration
@Order(Integer.MAX_VALUE)
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private TokenEnhancer tokenEnhancer;


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.
                tokenStore(tokenStore).
                authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
        if(jwtAccessTokenConverter != null ){
            endpoints.accessTokenConverter(jwtAccessTokenConverter);
            if(tokenEnhancer != null){
                TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
                List<TokenEnhancer> delegates = new ArrayList<>();
                delegates.add(tokenEnhancer);
                delegates.add(jwtAccessTokenConverter); // 注意必须要加入jwtAccessTokenConverter 否则无法转化
                tokenEnhancerChain.setTokenEnhancers(delegates);
                endpoints.tokenEnhancer(tokenEnhancerChain);
            }
        }
    }

    /**
     * TODO 从DB 中读取数据
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
        builder
                .withClient("webuy")
                .secret(bCryptPasswordEncoder.encode("webuy123"))
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(60 * 60 * 24 * 30)
                .autoApprove(true)
                .authorizedGrantTypes("refresh_token", "password", "authorization_code")
                .scopes("all");
        builder
                .withClient("browser")
                .secret(bCryptPasswordEncoder.encode("123"))
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(60 * 60 * 24 * 30)
                .autoApprove(true)
                .authorizedGrantTypes("refresh_token", "password", "authorization_code")
                .scopes("all");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("isAuthenticated()");
//          .tokenKeyAccess("permitAll()")
//                .checkTokenAccess("permitAll()")
    }


}
