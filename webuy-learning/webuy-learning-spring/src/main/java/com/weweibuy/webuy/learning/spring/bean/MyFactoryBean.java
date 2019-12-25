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
        Object o = Proxy.newProxyInstance(IValue.class.getClassLoader(), new Class[]{IValue.class}, (a, b, c) -> {
            if (s == null) {
                s = new MyCacheBean().getValue();
            }
            return s;

        });
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return IValue.class;
    }
}
