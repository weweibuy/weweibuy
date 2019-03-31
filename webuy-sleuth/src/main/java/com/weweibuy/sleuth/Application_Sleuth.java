package com.weweibuy.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @ClassName Application_Sleuth
 * @Description
 * @Author durenhao
 * @Date 2019/3/30 22:41
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableZipkinServer
public class Application_Sleuth {

    public static void main(String[] args) {
        SpringApplication.run(Application_Sleuth.class);
    }

}
