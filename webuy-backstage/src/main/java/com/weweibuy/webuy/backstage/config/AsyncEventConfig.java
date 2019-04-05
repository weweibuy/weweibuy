package com.weweibuy.webuy.backstage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.Executors;

/**
 * @ClassName AsyncEvent
 * @Description
 * @Author durenhao
 * @Date 2019/3/16 21:55
 **/
//@Controller
public class AsyncEventConfig {

    @Bean
    public SimpleApplicationEventMulticaster eventMulticaster(){
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setTaskExecutor(Executors.newFixedThreadPool(3));
        return multicaster;
    }
}
