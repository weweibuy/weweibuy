package com.weweibuy.webuy.learning.spring.aop;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author durenhao
 * @date 2019/12/25 22:27
 **/
public class MyStaticMethodMatcherPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        AopAnnotation annotation = method.getAnnotation(AopAnnotation.class);
        return annotation != null;
    }
}
