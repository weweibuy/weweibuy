package com.weweibuy.annotation;

import com.weweibuy.webuy.backstage.controller.Hellow;
import org.junit.Test;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * @ClassName AnnotationTest
 * @Description
 * @Author durenhao
 * @Date 2019/3/17 17:02
 **/
public class AnnotationTest {

    @Test
    public void test01() throws NoSuchMethodException {
        Class<Hellow> clazz = Hellow.class;

        Method method = clazz.getDeclaredMethod("users", String.class);
        AnnotatedElement element = method;

        AnnotationAttributes attributes = AnnotatedElementUtils.findMergedAnnotationAttributes(element, Cacheable.class, false, false);

        System.err.println(attributes.toString());


    }

}
