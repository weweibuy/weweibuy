package com.weweibuy.webuy.learning.event.event.advice;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.context.EventInvokeTargetContext;
import com.weweibuy.webuy.learning.event.event.model.BizEventVo;
import com.weweibuy.webuy.learning.event.event.store.EventStore;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/27 20:02
 **/
@Slf4j
@Component
public class AutoExitBizEventAdvice implements BizEventAdvice {


    @Override
    public Object process(EventContext context, EventInvokeTargetContext invokeTargetContext, Object event, ProceedingJoinPoint joinPoint, BizEventAdviceChain chain) throws Throwable {
        log.info("AutoExitBizEventAdvice  is running .... ");
        Object o = chain.doProcess(context, invokeTargetContext, event, joinPoint);
        EventStore eventStore = context.getEventStore();
        EventContext.CurrentEvent currentEvent = context.getCurrentEvent();
        if (o instanceof BizEventVo) {
            eventStore.exitEventAndAdd(currentEvent.getBizEvent(), (BizEventVo) o);
        } else {
            eventStore.exitEvent(currentEvent.getBizEvent());
        }
        return o;
    }

    @Override
    public Integer getOrder() {
        return Integer.MAX_VALUE - 1;
    }
}
