package com.weweibuy.webuy.learning.spring;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author durenhao
 * @date 2019/4/7 0:02
 **/
@EnableCaching
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableApolloConfig
@MapperScan(basePackages = {"com.weweibuy.webuy.learning.spring.mapper"})
public class Application_Learning_Spring {

    public static void main(String[] args) {
        SpringApplication.run(Application_Learning_Spring.class, args);
    }

}
