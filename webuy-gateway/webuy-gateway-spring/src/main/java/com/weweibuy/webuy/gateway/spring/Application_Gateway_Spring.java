package com.weweibuy.webuy.gateway.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author durenhao
 * @date 2019/4/20 19:18
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Application_Gateway_Spring {

    public static void main(String[] args) {
        SpringApplication.run(Application_Gateway_Spring.class, args);
    }

}
