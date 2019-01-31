package com.weweibuy.support;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 提供给各个工厂短信,邮件等的支持
 * @ClassName Application_Support
 * @Description
 * @Author durenhao
 * @Date 2019/1/19 18:13
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableRabbit
public class Application_Support {

    public static void main(String[] args) {
        SpringApplication.run(Application_Support.class);
    }

}
