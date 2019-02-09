package com.weweibuy.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 用户服务
 * @ClassName Application_User
 * @Description
 * @Author durenhao
 * @Date 2018/11/25 10:49
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.weweibuy.user.mapper"})
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.weweibuy.support.client")
@ComponentScan(basePackages = {"com.weweibuy.user", "com.weweibuy.support.client.fallback"}) // 防止映入外包扫描不到bean
public class Application_User {

    public static void main(String[] args) {
       SpringApplication.run(Application_User.class);
    }
}
