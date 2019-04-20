package com.weweibuy.webuy.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * TODO zuul 的host timeout  hystrix的threadtimeout  与 ribbon 的ConnectTimeout和ReadTimeout 的联系和意义
 * @ClassName Application_Gateway
 * @Description
 * @Author durenhao
 * @Date 2018/9/22 20:59
 **/
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
//@EnableOAuth2Sso // 代理客户端进行权限认证
@EnableResourceServer //  zuul代理所有资源服务
public class Application_Gateway_Zuul {

    public static void main(String[] args) {
        SpringApplication.run(Application_Gateway_Zuul.class, args);
    }
}