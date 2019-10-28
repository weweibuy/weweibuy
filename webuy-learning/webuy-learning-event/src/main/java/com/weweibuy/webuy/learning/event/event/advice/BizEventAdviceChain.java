package com.weweibuy.webuy.learning.event.event.advice;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.context.EventInvokeTargetContext;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author durenhao
 * @date 2019/10/27 17:35
 **/
public interface BizEventAdviceChain {

    Object doProcess(EventContext context, EventInvokeTargetContext invokeTargetContext, Object event, ProceedingJoinPoint joinPoint) throws Throwable;


}
