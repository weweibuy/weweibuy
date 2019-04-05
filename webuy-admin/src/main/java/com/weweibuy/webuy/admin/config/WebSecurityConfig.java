package com.weweibuy.webuy.admin.config;

import com.weweibuy.webuy.admin.security.RedirectAuthenticationSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName WebSecurityConfig
 * @Description
 * @Author durenhao
 * @Date 2019/1/21 23:28
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        RedirectAuthenticationSuccessHandler successHandler = new RedirectAuthenticationSuccessHandler("/");

        http.authorizeRequests()
                .antMatchers( "/assets/**").permitAll()
                .antMatchers( "/login",
                        "/instances/**",
                        "/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage( "/login").successHandler(successHandler)
                .and()
                .httpBasic().disable()
                .csrf().disable();
    }

}
