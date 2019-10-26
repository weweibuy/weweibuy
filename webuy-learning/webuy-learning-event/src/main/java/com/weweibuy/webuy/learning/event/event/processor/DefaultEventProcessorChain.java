package com.weweibuy.webuy.learning.event.event.processor;

import com.weweibuy.webuy.learning.event.event.context.EventContext;

/**
 * @author durenhao
 * @date 2019/10/26 20:45
 **/
public class DefaultEventProcessorChain extends EventProcessorChain {

    private AbstractLinkedEventProcessor first = new AbstractLinkedEventProcessor() {
        @Override
        public Integer getOrder() {
            return Integer.MIN_VALUE + 1;
        }

        @Override
        public void process(EventContext eventContext, Object param) {
            super.next(eventContext, param);
        }
    };

    private AbstractLinkedEventProcessor end = first;

    @Override
    public void process(EventContext eventContext, Object param) {
        first.process(eventContext, param);
    }

    @Override
    public void addLatest(AbstractLinkedEventProcessor eventProcessor) {
        end.setNext(eventProcessor);
        this.end = eventProcessor;
    }

    @Override
    public Integer getOrder() {
        return Integer.MIN_VALUE;
    }
}
