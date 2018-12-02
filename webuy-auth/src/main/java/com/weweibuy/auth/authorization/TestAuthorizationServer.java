package com.weweibuy.auth.authorization;

import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestAuthorizationServer
 * @Description
 * @Author durenhao
 * @Date 2018/12/1 20:17
 **/
@Component
public class TestAuthorizationServer implements AuthorizationServerConfigurer {

    /**
     * 声明安全约束，哪些允许访问，哪些不允许访问
     * 如： jdbc需要调用JdbcClientDetailsService类，此类需要传入相应的DataSource.
     * @param authorizationServerSecurityConfigurer
     * @throws Exception
     */
    public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) throws Exception {

    }

    /**
     * client客户端的信息配置，client信息包括：clientId、secret、scope、authorizedGrantTypes、authorities
     * client的信息的读取, 可以有in-memory、jdbc等多种读取方式
     * @param clientDetailsServiceConfigurer
     * @throws Exception
     */
    public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {

    }

    /**
     * 声明授权和token的端点以及token的服务的一些配置信息，
     * 比如采用什么存储方式、token的有效期等
     * @param authorizationServerEndpointsConfigurer
     * @throws Exception
     */
    public void configure(AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer) throws Exception {

    }
}
