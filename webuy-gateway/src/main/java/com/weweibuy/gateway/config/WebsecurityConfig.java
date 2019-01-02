package com.weweibuy.gateway.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * web安全配置
 * @ClassName Oauth2WebsecurityConfigurer
 * @Description
 * @Author durenhao
 * @Date 2018/12/15 11:11
 **/
public class WebsecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() /* .antMatchers().hasAnyRole("ADMIN") */
                .antMatchers("/auth/**","/hello",  "/backstage/hello", "*.css", "*.js", "*.fonts")
                .permitAll()
                .anyRequest()
                .authenticated()
            .and().
                csrf().disable()
                //Spring Security默认将header response里的X-Frame-Options属性设置为DENY。
                //页面里有需要通过iframe/frame引用的页面，需要配置Spring Security允许iframe frame加载同源的资源，方法为在Spring Security的配置类里将header response的X-Frame-Options属性设置为SAMEORIGIN
                .headers().frameOptions().sameOrigin(); //

    }


}