package com.weweibuy.webuy.eureka.config;

import com.weweibuy.webuy.eureka.security.RedirectAuthenticationSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName WebSecurityConfig
 * @Description
 * @Author durenhao
 * @Date 2018/10/21 11:22
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        RedirectAuthenticationSuccessHandler successHandler = new RedirectAuthenticationSuccessHandler("/");
//        successHandler.setTargetUrlParameter("redirectTo");
//        successHandler.setDefaultTargetUrl("/");



        http.authorizeRequests()
                .antMatchers( "/login.html", "/fonts/**", "/css/**", "/img/**", "/js/**",
                        "/instances/**", "/services/**", "/assets/**", "/eureka/**",
                        "/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage( "/login.html")
                .loginProcessingUrl("/loginProcessing")
                .successHandler(successHandler)
                .and()
                .httpBasic().disable()
                .csrf().disable();
    }
}
