package com.weweibuy.webuy.learning.event.event.context;

/**
 * @author durenhao
 * @date 2019/10/27 18:20
 **/
public class EventContextHolder {

    private static final ThreadLocal<EventContext> THREAD_LOCAL = new ThreadLocal<>();

    public static void setContext(EventContext eventContext) {
        THREAD_LOCAL.set(eventContext);
    }

    public static EventContext getContext() {
        return THREAD_LOCAL.get();
    }

    public static void clearContext() {
        THREAD_LOCAL.remove();
    }

}
