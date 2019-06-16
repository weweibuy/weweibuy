package com.weweibuy.webuy.learning.spring.service;

import com.weweibuy.webuy.learning.spring.annotation.LifeCycle;
import com.weweibuy.webuy.learning.spring.annotation.MyAnnotation;
import com.weweibuy.webuy.learning.spring.model.TestListVo;
import com.weweibuy.webuy.learning.spring.model.eum.BillTypeEum;
import com.weweibuy.webuy.learning.spring.model.eum.ChannelCodeEum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;


/**
 * @author durenhao
 * @date 2019/6/11 22:23
 **/
@Slf4j
@Service
public class DispatcherService implements InitializingBean {

    private Map<String, TypeInterface> typeMap = new HashedMap<>();

    @Autowired
    private List<TypeInterface> typeInterfaceList;

    @Autowired
    private BTypeInterfaceImpl bTypeInterface;

    @Autowired
    private ApplicationContext applicationContext;

    public void doDispatcher(String name) throws InvocationTargetException, IllegalAccessException {
        TypeInterface typeInterface = typeMap.get(name);
        Class<? extends TypeInterface> clazz = typeInterface.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method method : declaredMethods){
            if(method.isAnnotationPresent(LifeCycle.class)){
                method.invoke(typeInterface, new TestListVo());
            }
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        int size = typeInterfaceList.size();
        typeInterfaceList.forEach(typeInterface -> {
            Class<? extends TypeInterface> clazz = typeInterface.getClass();
            boolean b = AnnotatedElementUtils.hasAnnotation(clazz, MyAnnotation.class);
            if (b) {
                MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
                BillTypeEum billTypeEum = annotation.billType();
                ChannelCodeEum channel = annotation.channel();
                String name = billTypeEum.toString() + "." + channel.toString();
                synchronized (this) {
                    if (typeMap.get(name) == null) {
                        typeMap.put(name, typeInterface);
                    } else {
                        TypeInterface cacheType = typeMap.get(name);
                        Class<? extends TypeInterface> cacheTypeClass = cacheType.getClass();
                        boolean b1 = AnnotatedElementUtils.hasAnnotation(clazz, Primary.class);
                        boolean b2 = AnnotatedElementUtils.hasAnnotation(cacheTypeClass, Primary.class);

                        if (b1 && b2) {
                            boolean b3 = AnnotatedElementUtils.hasAnnotation(clazz, Deprecated.class);
                            boolean b4 = AnnotatedElementUtils.hasAnnotation(cacheTypeClass, Deprecated.class);

                            throw new RuntimeException("不能同时被Primary标记");
                        }

                        if (!b1 && !b2) {
                            throw new RuntimeException("必须有一个被Primary标记");
                        }
                        if (b1) {
                            typeMap.put(name, typeInterface);
                        }
                    }
                }


            }
        });
        int size1 = typeMap.size();
    }
}
