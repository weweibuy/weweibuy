package com.weweibuy.webuy.learing.mq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author durenhao
 * @date 2019/8/31 9:36
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MqProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqProducerApplication.class, args);
    }

}
