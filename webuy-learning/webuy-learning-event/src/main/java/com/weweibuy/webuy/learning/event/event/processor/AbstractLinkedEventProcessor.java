package com.weweibuy.webuy.learning.event.event.processor;

import com.weweibuy.webuy.learning.event.event.context.EventContext;

/**
 * @author durenhao
 * @date 2019/10/26 20:46
 **/
public abstract class AbstractLinkedEventProcessor<T> implements EventProcessor<T> {

    private AbstractLinkedEventProcessor next;

    @Override
    public void next(EventContext eventContext, Object param) {
        if (next != null) {
            next.process(eventContext, param);
        }
    }


    public void setNext(AbstractLinkedEventProcessor next) {
        this.next = next;
    }

    public abstract Integer getOrder();

}
