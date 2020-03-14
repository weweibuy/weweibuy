package com.weweibuy.webuy.learning.feign.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author durenhao
 * @date 2019/12/24 21:25
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.weweibuy.webuy.learning.feign.consume.client"})
@EnableAsync
public class FeignConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumeApplication.class, args);
    }

}
