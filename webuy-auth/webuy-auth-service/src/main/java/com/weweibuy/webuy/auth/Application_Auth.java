package com.weweibuy.webuy.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.social.config.annotation.EnableSocial;

/**
 * 权限服务
 * TODO 登录或处理页面是有大量的 redisConnection  Opening 和 Closing 需要弄清是谁在操作是否影响性能是否可以优化
 * @ClassName Application_Auth
 * @Description
 * @Author durenhao
 * @Date 2018/12/15 10:41
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableAuthorizationServer
@EnableFeignClients(basePackages = "com.weweibuy.user.client") // 这里需要指定basePackages否则找不到bean
@EnableSocial
@ComponentScan(basePackages = {"com.weweibuy.webuy.auth", "com.weweibuy.user.client.fallback"})
public class Application_Auth {

    public static void main(String[] args) {
        SpringApplication.run(Application_Auth.class);
    }
}
