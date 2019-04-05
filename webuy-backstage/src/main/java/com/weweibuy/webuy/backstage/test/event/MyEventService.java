package com.weweibuy.webuy.backstage.test.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyEventService
 * @Description
 * @Author durenhao
 * @Date 2019/3/16 21:06
 **/
@Slf4j
@Component
public class MyEventService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void pushEvent(){
        this.applicationContext.publishEvent(new MyEvent("hello..Spring..event"));
        log.error("do..mybiz");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
