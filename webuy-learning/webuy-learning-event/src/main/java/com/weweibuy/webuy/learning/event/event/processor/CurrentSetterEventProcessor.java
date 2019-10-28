package com.weweibuy.webuy.learning.event.event.processor;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.model.BizEventVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/27 23:59
 **/
@Slf4j
@Component
public class CurrentSetterEventProcessor extends AbstractLinkedEventProcessor<BizEventVo> {

    @Override
    public void process(EventContext eventContext, BizEventVo param) {
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
