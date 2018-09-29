package com.weweibuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName Application_Gateway
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/22 20:59
 **/
@SpringBootApplication
@EnableZuulProxy
public class Application_Gateway {

    public static void main(String[] args) {
        SpringApplication.run(Application_Gateway.class);
    }
}
