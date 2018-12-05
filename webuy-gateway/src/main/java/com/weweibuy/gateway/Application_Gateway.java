package com.weweibuy.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @ClassName Application_Gateway
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/22 20:59
 **/
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@EnableOAuth2Sso // 代理客户端进行权限认证
@EnableResourceServer
public class Application_Gateway {

    public static void main(String[] args) {
        SpringApplication.run(Application_Gateway.class);
    }
}