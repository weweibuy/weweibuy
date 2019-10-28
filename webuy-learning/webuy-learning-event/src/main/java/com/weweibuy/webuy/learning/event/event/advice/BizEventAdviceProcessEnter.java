package com.weweibuy.webuy.learning.event.event.advice;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.context.EventInvokeTargetContext;
import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/10/27 17:38
 **/
@Data
public class BizEventAdviceProcessEnter implements BizEventAdviceChain {

    private int pos = 0;

    private int size;

    private List<BizEventAdvice> bizEventAdviceList;

    @Override
    public Object doProcess(EventContext context, EventInvokeTargetContext invokeTargetContext, Object event, ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        if (pos < size) {
            BizEventAdvice bizEventAdvice = bizEventAdviceList.get(pos++);
            result = bizEventAdvice.process(context, invokeTargetContext, event, joinPoint, this);
        }
        return result;
    }

}
