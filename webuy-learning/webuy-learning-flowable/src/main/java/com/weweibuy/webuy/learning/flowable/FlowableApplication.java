package com.weweibuy.webuy.learning.flowable;

import org.flowable.spring.boot.FlowableSecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author durenhao
 * @date 2020/7/16 22:20
 **/
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, FlowableSecurityAutoConfiguration.class})
public class FlowableApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowableApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer swaggerDocsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/docs").setViewName("redirect:/docs/");
                registry.addViewController("/docs/").setViewName("forward:/docs/index.html");
            }
        };
    }
}
