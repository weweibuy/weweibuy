package com.weweibuy.webuy.learning.spring.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author durenhao
 * @date 2019/10/19 19:38
 **/
//@Component
@Aspect
@Slf4j
public class RestControllerAdvice {


    @Pointcut(value = "@within(org.springframework.web.bind.annotation.RestController)")
    public void pc(){

    }


    @Around(value = "pc()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        log.info("controller 前处理 ..... ");
        return joinPoint.proceed();
    }


}
