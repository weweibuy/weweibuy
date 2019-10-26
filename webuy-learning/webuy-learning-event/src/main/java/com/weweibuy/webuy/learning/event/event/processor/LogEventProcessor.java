package com.weweibuy.webuy.learning.event.event.processor;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/10/26 21:55
 **/
@Slf4j
@Component
public class LogEventProcessor extends AbstractLinkedEventProcessor<List<BizEvent>> {


    @Override
    public void process(EventContext eventContext, List<BizEvent> param) {
        log.info("LogEventProcessor running ... ");
        next(eventContext, param);
    }

    @Override
    public Integer getOrder() {
        return 1;
    }
}
