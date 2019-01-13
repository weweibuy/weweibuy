package com.weweibuy.user.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName WebsecurityConfig
 * @Description
 * @Author durenhao
 * @Date 2019/1/8 22:00
 **/
@Configuration
@EnableOAuth2Sso // 这个必须写在这；在主启动类上报错
public class WebsecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() /* .antMatchers().hasAnyRole("ADMIN") */
                .antMatchers("/hello", "*.css", "*.js", "*.fonts")
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
