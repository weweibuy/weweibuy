package com.weweibuy.webuy.learning.event.event.processor;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/27 23:59
 **/
@Slf4j
@Component
public class CurrentSetterEventProcessor extends AbstractLinkedEventProcessor<BizEvent> {

    @Override
    public void process(EventContext eventContext, BizEvent param) {
        log.info("CurrentSetterEventProcessor  is running ....");
        try {
            eventContext.putCurrentEvent(param);
            next(eventContext, param);
        } finally {
            eventContext.removeCurrentEvent();
        }
    }

    @Override
    public Integer getOrder() {
        return 50;
    }
}
