package com.weweibuy.webuy.learning.spring.annotation;

import com.weweibuy.webuy.learning.spring.model.eum.BillTypeEum;
import com.weweibuy.webuy.learning.spring.model.eum.ChannelCodeEum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName MyAnnotation
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/30 13:41
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    ChannelCodeEum channel();

    BillTypeEum billType();

}
