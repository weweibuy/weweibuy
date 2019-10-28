package com.weweibuy.webuy.learning.event.event.advice;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.context.EventInvokeTargetContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/27 17:53
 **/
@Slf4j
@Component
public class ExceptionHandlerBizEventAdvice implements BizEventAdvice {


    @Override
    public Object process(EventContext context, EventInvokeTargetContext invokeTargetContext, Object event, ProceedingJoinPoint joinPoint, BizEventAdviceChain chain) throws Throwable {
        log.info("ExceptionHandler  advice is running .....");
        try {
            return chain.doProcess(context, invokeTargetContext, event, joinPoint);
        } catch (Throwable e) {
            log.error("事件发生异常 : {}", e);
            return null;
        }
    }

    @Override
    public Integer getOrder() {
        return 1;
    }
}
