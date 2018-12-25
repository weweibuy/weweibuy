package com.weweibuy.auth.config;

import com.weweibuy.auth.core.config.SmsCodeAuthenticationSecurityConfig;
import com.weweibuy.auth.core.filter.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * web安全配置
 * @ClassName ISecurityConfig
 * @Description
 * @Author durenhao
 * @Date 2018/12/15 11:11
 **/
@Configuration
public class ISecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler iAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler iAuthenticationFailureHandler;

    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private SpringSocialConfigurer iSpringSocialConfigurer;


    @Override
    protected void configure (HttpSecurity http) throws Exception{

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class).
            formLogin()  // 登录方式
                .loginPage("/webuy-login.html")
                .loginProcessingUrl("/authentication/form") // 处理登录页面的url
                .successHandler(iAuthenticationSuccessHandler)
                .failureHandler(iAuthenticationFailureHandler)
            .and()
                .apply(smsCodeAuthenticationSecurityConfig)
            .and()
                .apply(iSpringSocialConfigurer)
            .and()
                .authorizeRequests() //  对请求授权
                // 对指定目录放行
                .antMatchers("/webuy-login.html", "/fonts/*", "/css/*", "/img/*", "/js/*",
                        "/code/*", "/authentication/mobile", "/hello")
                .permitAll()
                .anyRequest()  // 所有请求
                .authenticated()  // 需要授权
//            .and().
//                rememberMe() // 记住我
//                .tokenRepository() // token 存储仓库
//                .tokenValiditySeconds() // token有效时间
//                .userDetailsService(userDetailsService)
            .and()
                .sessionManagement()
                .maximumSessions(1) // 最大允许的session
                .maxSessionsPreventsLogin(true) // 是佛允许剔除用户
                .expiredUrl("") //Session 失效跳转的url
            .and()
            .and()
                .logout()
                .logoutSuccessUrl("")
//                .logoutSuccessHandler() // 登出成功处理器
                .deleteCookies("JESSIONID")
                .logoutUrl("/logout")
            .and()
                .csrf()
                .disable();

    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //  密码加密方式
    }

//    @Bean
//    public PersistentTokenRepository persistentTokenRepository (){
//        return null;
//    }

}