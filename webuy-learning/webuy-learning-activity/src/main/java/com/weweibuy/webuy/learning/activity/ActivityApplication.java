package com.weweibuy.webuy.learning.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author durenhao
 * @date 2020/7/11 23:30
 **/
@SpringBootApplication
@EnableWebSecurity
public class ActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivityApplication.class, args);
    }

}
