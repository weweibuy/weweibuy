/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learning.event.event.context;

import com.weweibuy.webuy.learning.event.annotation.BlockHandler;
import com.weweibuy.webuy.learning.event.annotation.EventListenerWarp;
import com.weweibuy.webuy.learning.event.event.block.DefaultBlockHandler;
import com.weweibuy.webuy.learning.event.event.model.BizEventVo;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author durenhao
 * @date 2019/10/28 11:37
 **/
@Component
public class EventInvokeTargetContextHolder {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DefaultBlockHandler defaultBlockHandler;

    private ConcurrentHashMap<ClassMethodMetaDataKey, EventInvokeTargetMetaData> metaDataMap = new ConcurrentHashMap<>();

    public EventInvokeTargetMetaData getMetaData(final ProceedingJoinPoint proceedingJoinPoint) {
        ClassMethodMetaDataKey metaDataKey = getMetaDataKey(proceedingJoinPoint);
        EventInvokeTargetMetaData metaData = metaDataMap.get(metaDataKey);
        if (Objects.isNull(metaData)) {
            synchronized (this) {
                metaData = conventOperationToMetaData(proceedingJoinPoint);
                metaDataMap.put(metaDataKey, metaData);
            }
        }
        return metaData;
    }


    public EventInvokeTargetContext eventInvokeTargetContext(ProceedingJoinPoint proceedingJoinPoint, BizEventVo bizEventVo) {
        EventInvokeTargetMetaData metaData = getMetaData(proceedingJoinPoint);
        return new EventInvokeTargetContext();
    }

    private EventInvokeTargetMetaData conventOperationToMetaData(final ProceedingJoinPoint proceedingJoinPoint) {
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        EventInvokeTargetMetaData eventInvokeTargetMetaData = new EventInvokeTargetMetaData();

        EventListenerWarp annotation = method.getAnnotation(EventListenerWarp.class);
        if (annotation != null) {
            eventInvokeTargetMetaData.setAutoDelete(annotation.autoDelete());
            eventInvokeTargetMetaData.setAutoSave(annotation.autoSave());
            BlockHandler blockHandler = annotation.blockHandler();
            if (annotation != null) {
                String bean = blockHandler.bean();
                String method1 = blockHandler.method();
                if (StringUtils.isNotBlank(bean) && StringUtils.isNotBlank(method1)) {
                    Object bean1 = applicationContext.getBean(bean);
                    Method[] methods = bean1.getClass().getMethods();
                    for (int i = 0; i < methods.length; i++) {
                        Method method2 = methods[i];
                        String name = method2.getName();
                        if (name.equals(method1)) {
                            eventInvokeTargetMetaData.setBlockHandler(bean1, method2);
                            break;
                        }
                    }
                }
                EventInvokeTargetMetaData.BlockHandler blockHandler1 = eventInvokeTargetMetaData.getBlockHandler();
            }

        }

        return new EventInvokeTargetMetaData();
    }


    private ClassMethodMetaDataKey getMetaDataKey(final ProceedingJoinPoint proceedingJoinPoint) {
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        return new ClassMethodMetaDataKey(proceedingJoinPoint.getClass(), method);
    }


    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    private class ClassMethodMetaDataKey implements Comparable<ClassMethodMetaDataKey> {

        private final Class<?> clazz;

        private final Method method;

        @Override
        public int compareTo(ClassMethodMetaDataKey other) {
            int i = this.clazz.getName().compareTo(other.getClazz().getName());
            if (i == 0) {
                i = this.method.getName().compareTo(other.getMethod().getName());
            }
            return i;
        }

    }


}
