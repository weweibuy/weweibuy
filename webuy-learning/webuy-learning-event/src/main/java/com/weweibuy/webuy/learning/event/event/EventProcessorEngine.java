package com.weweibuy.webuy.learning.event.event;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.model.BizEventVo;
import com.weweibuy.webuy.learning.event.event.processor.EventProcessor;
import com.weweibuy.webuy.learning.event.event.processor.EventProcessorChainHolder;
import com.weweibuy.webuy.learning.event.event.store.EventStore;
import com.weweibuy.webuy.learning.event.event.store.EventSupplier;
import com.weweibuy.webuy.learning.event.event.trigger.TriggerType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
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
@Slf4j
@Component
public class EventProcessorEngine implements InitializingBean {

    @Autowired
    private EventStore eventStore;

    private static final EventContext EVENT_CONTEXT = new EventContext();

    @Autowired
    private EventProcessorChainHolder eventProcessorChainHolder;

    public void process(TriggerType triggerType, EventSupplier supplier, Object... args) throws InterruptedException {
        EventProcessor chain = eventProcessorChainHolder.getChain();
        switch (triggerType) {
            case JOB_JDBC:
                List<BizEventVo> bizEventList = supplier.get();
                if (bizEventList.size() > 0) {
                    EVENT_CONTEXT.setCountDownLatch(new CountDownLatch(bizEventList.size()));
                    chain.process(EVENT_CONTEXT, bizEventList);
                    EVENT_CONTEXT.awaitForComplete();
                }
                return;
            case APPLICATION:
                List<BizEventVo> bizEventList1 = supplier.get();
                chain.process(EVENT_CONTEXT, bizEventList1);
                break;
            default:
                return;
        }

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        EVENT_CONTEXT.setEventStore(eventStore);
    }
}
