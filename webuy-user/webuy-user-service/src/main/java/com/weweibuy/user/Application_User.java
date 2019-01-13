package com.weweibuy.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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
public class Application_User {

    public static void main(String[] args) {
       SpringApplication.run(Application_User.class);
    }
}
