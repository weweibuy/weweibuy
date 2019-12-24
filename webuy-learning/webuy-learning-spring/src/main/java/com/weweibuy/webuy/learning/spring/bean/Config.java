package com.weweibuy.webuy.learning.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author durenhao
 * @date 2019/12/24 23:25
 **/
@Configuration
public class Config {

    @Bean
    public MyBeanRegister myBeanRegister(){
        return new MyBeanRegister();
    }
}
