package com.weweibuy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * auth2 对资源的配置
 * @ClassName ResourcesServerConfig
 * @Description
 * @Author durenhao
 * @Date 2018/12/1 19:49
 **/
@Configuration
public class ResourcesServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .exceptionHandling()
            .and()
            .authorizeRequests().anyRequest().authenticated()
            .and()
            .httpBasic();
    }


}
