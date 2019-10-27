package com.weweibuy.webuy.learning.event.event.advice;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.trigger.BizEventTrigger;
import com.weweibuy.webuy.learning.event.event.trigger.TriggerType;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author durenhao
 * @date 2019/10/27 23:34
 **/
@Slf4j
@Component
public class PushReturnEventAdvice implements BizEventAdvice {

    @Autowired
    private BizEventTrigger trigger;

    @Override
    public Object process(EventContext context, Object event, ProceedingJoinPoint joinPoint, BizEventAdviceChain chain) throws Throwable {
        Object o = chain.doProcess(context, event, joinPoint);
        if (o instanceof BizEvent) {
            BizEvent bizEvent = (BizEvent) o;
            // 树形转list
            trigger.trigger(TriggerType.APPLICATION, args -> Collections.singletonList(bizEvent));
            return null;
        } else {
            return o;
        }
    }

    @Override
    public Integer getOrder() {
        return Integer.MAX_VALUE - 10;
    }
}
