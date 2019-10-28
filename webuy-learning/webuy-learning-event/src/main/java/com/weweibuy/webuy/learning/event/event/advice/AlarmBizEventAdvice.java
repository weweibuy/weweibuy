package com.weweibuy.webuy.learning.event.event.advice;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.context.EventInvokeTargetContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/27 20:00
 **/
@Slf4j
@Component
public class AlarmBizEventAdvice implements BizEventAdvice {


    @Override
    public Object process(EventContext context, EventInvokeTargetContext invokeTargetContext, Object event, ProceedingJoinPoint joinPoint, BizEventAdviceChain chain) throws Throwable {
        log.info("AlarmBizEventAdvice  is running ....");
        return chain.doProcess(context, invokeTargetContext, event, joinPoint);
    }

    @Override
    public Integer getOrder() {
        return 30;
    }
}
