package com.weweibuy.webuy.learning.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/9/16 23:07
 **/
@Slf4j
@Component
public class MyEventListener4 {


    @Async
    @EventListener
    public void onEvent(MyEvent myEvent){

        log.error("Listener4: msg: {}", myEvent.getMsg());
    }

    @Async
    @EventListener
    public void onEvent2(TestEvent myEvent){
        log.info(" test listener: msg: {}", myEvent.getMsg());

    }


}
