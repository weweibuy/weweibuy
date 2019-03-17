package com.weweibuy.test.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyEventListener
 * @Description
 * @Author durenhao
 * @Date 2019/3/16 21:09
 **/
@Slf4j
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {


    @Async
    @Override
    public void onApplicationEvent(MyEvent event) {
        try {
            Thread.sleep(550);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.error(event.getName());
        log.error(event.getSource().toString());
    }
}
