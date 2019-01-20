package com.weweibuy.gateway.config;

import com.weweibuy.gateway.authentication.cookie.CookieAuthenticationFilter;
import com.weweibuy.gateway.filter.CookieFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
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
    private AuthenticationEntryPoint iAuthenticationEntryPoint;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private CookieFilter cookieFilter;

    @Autowired
    private ResourceServerTokenServices tokenServices;

    private AuthenticationManager authenticationManager;

    @Autowired
    private CookieAuthenticationFilter cookieAuthenticationFilter;

    /**
     * TODO 这里的http  不能使用WebSecurityConfigurerAdapter的http配置; 必须这在配
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
//        CookieAuthenticationFilter cookieAuthenticationFilter = new CookieAuthenticationFilter();
//        http.addFilterBefore(cookieAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        cookieAuthenticationFilter.setAuthenticationManager(oauthAuthenticationManager(http));
        ResourceServerSecurityConfigurer configurer = http.getConfigurer(ResourceServerSecurityConfigurer.class);
        configurer.authenticationManager(oauthAuthenticationManager(http));
        http.addFilterBefore(cookieAuthenticationFilter, RequestCacheAwareFilter.class);
        http.addFilterBefore(cookieFilter, HeaderWriterFilter.class);
        http
            .authorizeRequests() /* .antMatchers().hasAnyRole("ADMIN") */
            .antMatchers("/auth/**","/*/hello", "/*/js/**", "/*/css/**", "/*/fonts/**", "**/favicon.ico","/actuator/**",
                             "/user/register/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and().
                csrf().disable()
                //Spring Security默认将header response里的X-Frame-Options属性设置为DENY。
                //页面里有需要通过iframe/frame引用的页面，需要配置Spring Security允许iframe frame加载同源的资源，方法为在Spring Security的配置类里将header response的X-Frame-Options属性设置为SAMEORIGIN
                .headers().frameOptions().sameOrigin(); //

//        http.apply(cookieConfig);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resource) throws Exception {
        resource.authenticationEntryPoint(iAuthenticationEntryPoint);
        resource.accessDeniedHandler(accessDeniedHandler);
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

    private AuthenticationManager oauthAuthenticationManager(HttpSecurity http) {
        if(this.authenticationManager == null){
            OAuth2AuthenticationManager oauthAuthenticationManager = new OAuth2AuthenticationManager();
            oauthAuthenticationManager.setResourceId("oauth2-resource");
            oauthAuthenticationManager.setTokenServices(tokenServices);
            oauthAuthenticationManager.setClientDetailsService(http.getSharedObject(ClientDetailsService.class));
            this.authenticationManager = oauthAuthenticationManager;
            return oauthAuthenticationManager;
        }
        return this.authenticationManager;
    }

}
