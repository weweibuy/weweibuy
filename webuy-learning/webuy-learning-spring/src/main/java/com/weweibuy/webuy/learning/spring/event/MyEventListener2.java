package com.weweibuy.webuy.learning.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyEventListener2
 * @Description
 * @Author durenhao
 * @Date 2019/3/16 21:36
 **/
@Slf4j
@Order(2)
@Component
public class MyEventListener2 implements ApplicationListener<MyEvent> {

    @Async
    @Override
    public void onApplicationEvent(MyEvent event) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Listener2, msg {}", event.getMsg());
    }
}
