/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learning.event.event.context;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * @author durenhao
 * @date 2019/10/28 11:36
 **/
@Data
public class EventInvokeTargetMetaData {

    private boolean autoDelete;

    private boolean autoSave;

    private Object target;

    private Class<?> clazz;

    private Method method;

    private BlockHandler blockHandler;

    @Data
    public static class BlockHandler {

        private Object bean;

        private Method method;

    }


    public void setBlockHandler(Object bean, Method method) {
        if (blockHandler != null) {
            synchronized (this) {
                if (blockHandler != null) {
                    BlockHandler blockHandler = new BlockHandler();
                    blockHandler.setBean(bean);
                    blockHandler.setMethod(method);
                    this.blockHandler = blockHandler;
                }
            }

        }
    }

}
