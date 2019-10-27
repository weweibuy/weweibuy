package com.weweibuy.webuy.learning.event.event.advice;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author durenhao
 * @date 2019/10/27 12:19
 **/
public interface BizEventAdvice {

    Object process(EventContext context, Object event, ProceedingJoinPoint joinPoint, BizEventAdviceChain chain) throws Throwable;

    Integer getOrder();
}
