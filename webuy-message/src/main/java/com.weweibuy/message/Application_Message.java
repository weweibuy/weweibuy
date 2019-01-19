package com.weweibuy.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 该工程用于在分布式环境下,基于可靠消息的方式和RabbitMQ的ACK机制,实现对数据一致的保证
 * @ClassName Application_Message
 * @Description
 * @Author durenhao
 * @Date 2018/10/11 16:05
 **/
@SpringBootApplication
@EnableRabbit
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.weweibuy.message.mapper"})
@EnableDiscoveryClient
@EnableEurekaClient
public class Application_Message {

    public static void main(String[] args) {
        SpringApplication.run(Application_Message.class);
    }

}
