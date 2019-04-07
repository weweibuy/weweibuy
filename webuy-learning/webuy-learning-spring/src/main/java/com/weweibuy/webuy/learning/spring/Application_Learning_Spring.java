package com.weweibuy.webuy.learning.spring;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author durenhao
 * @date 2019/4/7 0:02
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableApolloConfig
public class Application_Learning_Spring {

    public static void main(String[] args) {
        SpringApplication.run(Application_Learning_Spring.class, args);
    }

}
