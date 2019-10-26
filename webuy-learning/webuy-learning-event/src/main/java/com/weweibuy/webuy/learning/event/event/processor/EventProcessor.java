package com.weweibuy.webuy.learning.event.event.processor;

import com.weweibuy.webuy.learning.event.event.context.EventContext;

/**
 * @author durenhao
 * @date 2019/10/26 20:38
 **/
public interface EventProcessor<T> {

    /**
     * 处理
     */
    void process(EventContext eventContext, T param);

    /**
     * 下一个
     */
    void next(EventContext eventContext, Object param);



}
