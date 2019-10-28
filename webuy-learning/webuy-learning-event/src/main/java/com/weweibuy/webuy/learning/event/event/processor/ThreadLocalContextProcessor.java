package com.weweibuy.webuy.learning.event.event.processor;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.context.EventContextHolder;
import com.weweibuy.webuy.learning.event.event.model.BizEventVo;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/27 18:24
 **/
@Component
public class ThreadLocalContextProcessor extends AbstractLinkedEventProcessor<BizEventVo> {


    @Override
    public void process(EventContext eventContext, BizEventVo param) {
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
