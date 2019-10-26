package com.weweibuy.webuy.learning.event.event.processor;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

/**
 * @author durenhao
 * @date 2019/10/26 20:40
 **/
@Component
public class EventProcessorChainHolder implements InitializingBean {

    @Autowired
    private List<AbstractLinkedEventProcessor> eventProcessorList;

    private EventProcessor eventProcessorChain;

    public EventProcessor getChain() {
        return eventProcessorChain;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        DefaultEventProcessorChain defaultEventProcessorChain = new DefaultEventProcessorChain();
        eventProcessorList.stream().sorted(Comparator.comparing(AbstractLinkedEventProcessor::getOrder))
                .forEach(defaultEventProcessorChain::addLatest);
        this.eventProcessorChain = defaultEventProcessorChain;
    }
}
