package com.weweibuy.webuy.auth.core.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.io.IOException;

/**
 * token的存储方式配置
 * @ClassName TokenStoreConfig
 * @Description
 * @Author durenhao
 * @Date 2018/12/30 18:00
 **/
@Configuration("tokenStoreConfig")
public class TokenStoreConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    @ConditionalOnProperty(prefix = "webuy.security.ouath2", name = "tokenStore", havingValue = "redis", matchIfMissing = false)
    public RedisTokenStore redisTokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Configuration("jwtTokenStoreConfig")
    @ConditionalOnProperty(prefix = "webuy.security.ouath2", name = "tokenStore", havingValue = "jwt", matchIfMissing = true)
    public static class JwtTokenStoreConfig{

        @Bean
        public TokenStore jwtTokenStore(){
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter(){
            JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
            // 注意maven资源插件对jks污染
//            KeyStoreKeyFactory keyStoreKeyFactory =
//                    new KeyStoreKeyFactory(new ClassPathResource("jwt_rsa_private_key.jks"), "123456".toCharArray());
//            tokenConverter.setKeyPair(keyStoreKeyFactory.getKeyPair("jwt_rsa_private_key"));
            Resource resource = new ClassPathResource("jwt_rsa_private_key.txt");
            ClassPathResource resource1 = new ClassPathResource("jwt_rsa_public_key.txt");
            String privateKey = null;
            String publicKey = null;
            try {
                privateKey = IOUtils.toString(resource.getInputStream());
                publicKey = IOUtils.toString(resource1.getInputStream());
            } catch (final IOException e) {
                throw new RuntimeException(e);
            }
            tokenConverter.setSigningKey(privateKey);
            tokenConverter.setVerifierKey(publicKey);
            return tokenConverter;
        }

//        @Bean
//        public TokenEnhancer tokenEnhancer(){
//            return new JwtTokenEnhancer();
//        }

    }

}
