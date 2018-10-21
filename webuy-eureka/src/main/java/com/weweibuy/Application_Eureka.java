package com.weweibuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @ClassName Application_Eureka
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/22 10:56
 **/

@SpringBootApplication
@EnableEurekaServer
@EnableWebSecurity
public class Application_Eureka {

    public static void main(String[] args) {
        SpringApplication.run(Application_Eureka.class);
    }
}
