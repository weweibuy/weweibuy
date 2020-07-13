package com.weweibuy.webuy.learning.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author durenhao
 * @date 2020/7/11 23:30
 **/
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivityApplication.class, args);
    }

}
