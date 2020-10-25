package com.weweibuy.webuy.learning.flowable;

import org.flowable.spring.boot.FlowableSecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author durenhao
 * @date 2020/7/16 22:20
 **/
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, FlowableSecurityAutoConfiguration.class})
@EnableFeignClients
public class FlowableApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowableApplication.class, args);
    }

}
