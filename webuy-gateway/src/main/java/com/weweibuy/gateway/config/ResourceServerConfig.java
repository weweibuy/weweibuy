package com.weweibuy.gateway.config;

import com.weweibuy.gateway.filter.CookieFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 资源服务器配置，这里zuul代理了所有资源服务
 * @ClassName ResourceServerConfig
 * @Description
 * @Author durenhao
 * @Date 2018/12/5 22:02
 **/
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint IAuthenticationEntryPoint;

    @Autowired
    private CookieFilter clientIdFilter;

    /**
     * TODO这里的http  不能使用WebSecurityConfigurerAdapter的http配置; 必须这在配
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(clientIdFilter, HeaderWriterFilter.class);
        http
            .authorizeRequests() /* .antMatchers().hasAnyRole("ADMIN") */
            .antMatchers("/auth/**","/*/hello", "*.css", "*.js", "*.fonts", "/**/favicon.ico")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and().
                csrf().disable()
                //Spring Security默认将header response里的X-Frame-Options属性设置为DENY。
                //页面里有需要通过iframe/frame引用的页面，需要配置Spring Security允许iframe frame加载同源的资源，方法为在Spring Security的配置类里将header response的X-Frame-Options属性设置为SAMEORIGIN
                .headers().frameOptions().sameOrigin(); //

        http.exceptionHandling().authenticationEntryPoint(IAuthenticationEntryPoint);
    }

    /**
     * 用于解决zuul代理后cookie 跨域丢失
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);   // 允许cookies跨域
        config.addAllowedOrigin("*"); // 允许向该服务器提交请求的URI，*表示全部允许。。这里尽量限制来源域，比如http://xxxx:8080 ,以降低安全风险。。
        config.addAllowedHeader("*"); // 允许访问的头信息,*表示全部
        config.addAllowedMethod("*");
        config.setMaxAge(18000L); // 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
