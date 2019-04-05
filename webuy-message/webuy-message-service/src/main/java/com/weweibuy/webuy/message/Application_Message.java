package com.weweibuy.webuy.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 该工程用于在分布式环境下,基于可靠消息的方式和RabbitMQ的ACK机制,实现对数据一致的保证
 * @ClassName Application_Message
 * @Description
 * @Author durenhao
 * @Date 2018/10/11 16:05
 **/
@SpringBootApplication
@EnableRabbit
@MapperScan(basePackages = {"com.weweibuy.webuy.message.mapper"})
@EnableDiscoveryClient
@EnableEurekaClient
@EnableSwagger2
public class Application_Message {

    public static void main(String[] args) {
        SpringApplication.run(Application_Message.class, args);
    }

}
