package com.weweibuy.webuy.learning.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyEventListener3
 * @Description
 * @Author durenhao
 * @Date 2019/3/16 21:40
 **/
@Slf4j
@Component
public class MyEventListener3 {


    @Async
    @EventListener
    public void eventListener(MyEvent myEvent){
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.error(myEvent.getSource().toString());
    }
}
