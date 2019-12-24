package com.weweibuy.webuy.learning.spring.bean;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author durenhao
 * @date 2019/12/24 23:07
 **/
public class MyFactoryBean implements FactoryBean<Object> {

    private String s = null;

    @Override
    public Object getObject() throws Exception {
        Class<?>[] cArr = {IValue.class};
        Object o = Proxy.newProxyInstance(MyCacheBean.class.getClassLoader(), cArr, (a, b, c) -> {
            if (s != null) {
                return b.invoke(c);
            } else {
                return s;
            }
        });
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return MyCacheBean.class;
    }
}
