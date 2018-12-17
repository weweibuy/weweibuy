package com.weweibuy.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 权限服务
 * @ClassName Application_Auth
 * @Description
 * @Author durenhao
 * @Date 2018/12/15 10:41
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableAuthorizationServer
public class Application_Auth {

    public static void main(String[] args) {
        SpringApplication.run(Application_Auth.class);
    }
}
