package com.weweibuy.webuy.learning.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author durenhao
 * @date 2019/12/25 22:34
 **/
@Configuration("myAopConfig")
public class Config {


    @Bean
    public MyAdvisor myAdvisor(){
        MyAdvisor myAdvisor = new MyAdvisor();
        myAdvisor.setPc(new MyStaticMethodMatcherPointcut());
        myAdvisor.setAdvice(new MyMethodInterceptor());
        return myAdvisor;
    }



}
