package com.weweibuy.webuy.learning.spring.annotation;

import com.weweibuy.webuy.learning.spring.model.eum.BillLifeCycleEum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author durenhao
 * @date 2019/6/12 22:32
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LifeCycle {


    BillLifeCycleEum lifeCycle();

}
