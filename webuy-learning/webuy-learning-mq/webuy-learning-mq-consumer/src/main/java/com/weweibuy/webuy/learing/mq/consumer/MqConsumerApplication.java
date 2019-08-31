package com.weweibuy.webuy.learing.mq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author durenhao
 * @date 2019/8/31 9:32
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqConsumerApplication.class, args);
    }

}
