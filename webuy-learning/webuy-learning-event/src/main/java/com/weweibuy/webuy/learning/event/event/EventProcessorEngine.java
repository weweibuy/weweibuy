package com.weweibuy.webuy.learning.event.event;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.processor.EventProcessor;
import com.weweibuy.webuy.learning.event.event.processor.EventProcessorChainHolder;
import com.weweibuy.webuy.learning.event.event.store.EventStore;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 事件处理引擎
 *
 * @author durenhao
 * @date 2019/10/26 12:05
 **/
@Component
public class EventProcessorEngine {

    @Autowired
    private EventStore eventStore;

    @Autowired
    private EventProcessorChainHolder eventProcessorChainHolder;

    public void process(Object... args) throws InterruptedException {
        List<BizEvent> event = eventStore.getEvent(args);
        EventProcessor chain = eventProcessorChainHolder.getChain();
        EventContext eventContext = new EventContext();
        if (event.size() > 0) {
            eventContext.setCountDownLatch(new CountDownLatch(event.size()));
            chain.process(eventContext, event);
            eventContext.await();
        }
    }


}
