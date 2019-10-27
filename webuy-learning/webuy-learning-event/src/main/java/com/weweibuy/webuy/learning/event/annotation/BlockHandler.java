package com.weweibuy.webuy.learning.event.annotation;

/**
 * @author durenhao
 * @date 2019/10/27 19:49
 **/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BlockHandler {

    String bean() default "";

    String method() default "";

}
