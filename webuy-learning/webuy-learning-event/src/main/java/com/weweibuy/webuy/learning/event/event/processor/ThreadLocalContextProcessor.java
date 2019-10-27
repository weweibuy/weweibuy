package com.weweibuy.webuy.learning.event.event.processor;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.context.EventContextHolder;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;

/**
 * @author durenhao
 * @date 2019/10/27 18:24
 **/
public class ThreadLocalContextProcessor extends AbstractLinkedEventProcessor<BizEvent> {


    @Override
    public void process(EventContext eventContext, BizEvent param) {
        EventContextHolder.setContext(eventContext);
        try {
            next(eventContext, param);
        } finally {
            EventContextHolder.clearContext();
        }
    }

    @Override
    public Integer getOrder() {
        return 20;
    }
}
