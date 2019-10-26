package com.weweibuy.webuy.learning.event.event.listener;

import com.weweibuy.webuy.learning.event.annotation.EventListenerWarp;
import com.weweibuy.webuy.learning.event.event.model.AddTestBillEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/26 11:03
 **/
@Slf4j
@Component
public class TestListener {

    @EventListenerWarp
    public void simpleListener(AddTestBillEvent event){
        log.info("addTestBillEvent  被触发了 : {}", event);
    }


}
