package com.weweibuy.webuy.learning.event.event.trigger;

import com.weweibuy.webuy.learning.event.event.store.EventSupplier;

/**
 * @author durenhao
 * @date 2019/10/26 20:12
 **/
public interface BizEventTrigger {

    void trigger(TriggerType triggerType, EventSupplier supplier) throws Exception;

}
