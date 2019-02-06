package com.weweibuy.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName Application_Product
 * @Description
 * @Author durenhao
 * @Date 2019/2/6 19:11
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableSwagger2
@MapperScan(basePackages = {"com.weweibuy.product.mapper"})
public class Application_Product {

    public static void main(String[] args) {
        SpringApplication.run(Application_Product.class);
    }
}
