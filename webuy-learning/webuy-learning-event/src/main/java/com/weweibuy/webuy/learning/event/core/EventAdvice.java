package com.weweibuy.webuy.learning.event.core;

import com.weweibuy.webuy.learning.event.event.advice.BizEventAdvice;
import com.weweibuy.webuy.learning.event.event.advice.BizEventAdviceProcessEnter;
import com.weweibuy.webuy.learning.event.event.context.EventContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2019/9/22 12:58
 **/
@Slf4j
@Component
@Aspect
public class EventAdvice implements InitializingBean {

    @Autowired
    private List<BizEventAdvice> bizEventAdviceList;

    @Around("@annotation(com.weweibuy.webuy.learning.event.annotation.EventListenerWarp)")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            log.info("before event");
            BizEventAdviceProcessEnter bizEventAdviceProcessEnter = new BizEventAdviceProcessEnter();
            bizEventAdviceProcessEnter.setSize(bizEventAdviceList.size());
            bizEventAdviceProcessEnter.setBizEventAdviceList(bizEventAdviceList);

            Object[] args = joinPoint.getArgs();
            Object arg = args[0];
            Object o = bizEventAdviceProcessEnter.doProcess(EventContextHolder.getContext(), arg, joinPoint);

            log.info("after event");

            return o;
        } catch (Throwable e) {
            log.error("事件切面捕获到异常", e);
            throw new RuntimeException(e);
        }
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        bizEventAdviceList = bizEventAdviceList.stream().sorted(Comparator.comparing(BizEventAdvice::getOrder))
                .collect(Collectors.toList());
    }
}
