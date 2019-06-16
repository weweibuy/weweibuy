package com.weweibuy.webuy.learning.sharing;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author durenhao
 * @date 2019/6/15 16:25
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.weweibuy.webuy.learning.sharing.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableApolloConfig
public class ApplicationSharing {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationSharing.class, args);
    }

}
