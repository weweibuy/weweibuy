package com.weweibuy.conifg;

import com.weweibuy.controller.interceptor.CookieInterceptor;
import com.weweibuy.controller.interceptor.PermissionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebMvcConfig
 * @Description
 * @Author durenhao
 * @Date 2018/10/17 11:45
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(cookieInterceptor());
        registry.addInterceptor(permissionInterceptor());
    }

    /**
     * 自己定义的拦截器类
     * @return
     */
    @Bean
    public CookieInterceptor cookieInterceptor() {
        return new CookieInterceptor();
    }

    @Bean
    public PermissionInterceptor permissionInterceptor() {
        return new PermissionInterceptor();
    }


}
