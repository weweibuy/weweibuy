package com.weweibuy.webuy.inventory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 库存模块
 * @ClassName Application_Inventory
 * @Description
 * @Author durenhao
 * @Date 2019/2/8 14:07
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan(basePackages = "com.weweibuy.webuy.inventory.mapper")
public class Application_Inventory {

    public static void main(String[] args) {
        SpringApplication.run(Application_Inventory.class, args);
    }
}
