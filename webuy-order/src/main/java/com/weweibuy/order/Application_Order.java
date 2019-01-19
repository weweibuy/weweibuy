package com.weweibuy.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Application_Order
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 19:34
 **/
@SpringBootApplication
@EnableRabbit
@MapperScan(basePackages = {"com.weweibuy.order.mapper"})
public class Application_Order {

    public static void main(String[] args) {
        SpringApplication.run(Application_Order.class);
    }
}
