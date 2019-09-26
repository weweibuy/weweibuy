package com.weweibuy.webuy.learning.event.core;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/9/22 12:58
 **/
@Slf4j
@Component
@Aspect
public class EventAdvice {


    @Around("@annotation(com.weweibuy.webuy.learning.event.annotation.EventListenerWarp)")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            log.info("before event");
            Object proceed = joinPoint.proceed();
            log.info("after event");
            return proceed;
        } catch (Throwable e) {
            log.error("事件切面捕获到异常", e);
            throw new RuntimeException(e);
        }
    }


}
