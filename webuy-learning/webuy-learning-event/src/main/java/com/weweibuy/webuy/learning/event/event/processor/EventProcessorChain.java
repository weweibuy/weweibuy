package com.weweibuy.webuy.learning.event.event.processor;

/**
 * @author durenhao
 * @date 2019/10/23 22:55
 **/
public abstract class EventProcessorChain extends AbstractLinkedEventProcessor {

    public abstract void addLatest(AbstractLinkedEventProcessor eventProcessor);

}
