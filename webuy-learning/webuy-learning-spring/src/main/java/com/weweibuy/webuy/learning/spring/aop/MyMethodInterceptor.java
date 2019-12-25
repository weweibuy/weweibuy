package com.weweibuy.webuy.learning.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author durenhao
 * @date 2019/12/25 22:22
 **/
@Slf4j
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Object[] arguments = invocation.getArguments();
        log.info("执行MethodInterceptor 目标方法前执行.....");
        return invocation.proceed();

    }
}
