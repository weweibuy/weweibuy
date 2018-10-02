package com.weweibuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @ClassName Application_Gateway
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/22 20:59
 **/
@SpringBootApplication
@EnableZuulProxy
@EnableRedisHttpSession
public class Application_Gateway {

    public static void main(String[] args) {
        SpringApplication.run(Application_Gateway.class);
    }
}
