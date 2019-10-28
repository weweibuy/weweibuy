package com.weweibuy.webuy.learning.event.event.advice;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.context.EventInvokeTargetContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/27 18:31
 **/
@Component
@Slf4j
public class InvokeTargetBizEventAdvice implements BizEventAdvice {

    @Override
    public Object process(EventContext context, EventInvokeTargetContext invokeTargetContext, Object event, ProceedingJoinPoint joinPoint, BizEventAdviceChain chain) throws Throwable {
            log.info("InvokeTargetBizEventAdvice  is running .... ");
            return joinPoint.proceed();
    }

    @Override
    public Integer getOrder() {
        return Integer.MAX_VALUE;
    }
}
