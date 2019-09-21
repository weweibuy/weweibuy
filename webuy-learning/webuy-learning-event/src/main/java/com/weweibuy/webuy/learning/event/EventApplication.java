package com.weweibuy.webuy.learning.event;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author durenhao
 * @date 2019/9/21 17:48
 **/
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.weweibuy.webuy.learning.event.mapper"})
@SpringBootApplication
public class EventApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventApplication.class, args);
    }


}
