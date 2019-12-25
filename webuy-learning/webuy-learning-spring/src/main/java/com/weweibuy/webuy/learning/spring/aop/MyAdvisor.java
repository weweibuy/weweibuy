package com.weweibuy.webuy.learning.spring.aop;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;

/**
 * @author durenhao
 * @date 2019/12/25 22:25
 **/
public class MyAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    private MyStaticMethodMatcherPointcut pc ;


    public void setPc(MyStaticMethodMatcherPointcut pc) {
        this.pc = pc;
    }

    @Override
    public Pointcut getPointcut() {
        return this.pc = pc;
    }
}
