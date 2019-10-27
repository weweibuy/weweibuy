package com.weweibuy.webuy.learning.event.event.context;

import com.weweibuy.webuy.learning.event.event.store.EventStore;
import com.weweibuy.webuy.learning.event.event.trigger.TriggerType;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import lombok.Data;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author durenhao
 * @date 2019/10/26 21:30
 **/
@Data
public class EventContext {

    private static final ThreadLocal<CurrentEvent> BIZ_EVENT_THREAD_LOCAL = new ThreadLocal<>();

    private CountDownLatch countDownLatch;

    private EventStore eventStore;

    private ConcurrentHashMap<String, CurrentEvent> concurrentEventHashMap = new ConcurrentHashMap<>();

    @Data
    public static class CurrentEvent {

        private BizEvent bizEvent;

        private Boolean isChildEvent;

        private Integer order;

        private Boolean isBlock;

        private Boolean shouldAlarm;

        private Boolean shouldAddRetryCount;

        private Method blockMethod;

        private TriggerType triggerType;
    }

    public void awaitForComplete() throws InterruptedException {
        countDownLatch.await();
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void accomplishOneEvent() {
        countDownLatch.countDown();
    }

    public CurrentEvent getCurrentEvent() {
        return BIZ_EVENT_THREAD_LOCAL.get();
    }

    public void removeCurrentEvent() {
        BIZ_EVENT_THREAD_LOCAL.remove();
    }

    public boolean isContain(BizEvent eventNo) {
        return concurrentEventHashMap.containsKey(eventNo.getBizNo());
    }

    public void putCurrentEvent(BizEvent bizEvent) {
        CurrentEvent currentEvent = new CurrentEvent();
        currentEvent.setBizEvent(bizEvent);
        currentEvent.setOrder(bizEvent.getEventOrder());
        currentEvent.setTriggerType(bizEvent.getTriggerType());
        BIZ_EVENT_THREAD_LOCAL.set(currentEvent);
    }

}
