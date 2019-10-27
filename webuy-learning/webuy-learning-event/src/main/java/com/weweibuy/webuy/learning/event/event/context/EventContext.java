package com.weweibuy.webuy.learning.event.event.context;

import com.weweibuy.webuy.learning.event.event.store.EventStore;
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

    private CountDownLatch countDownLatch;

    private EventStore eventStore;

    private ConcurrentHashMap<String, CurrentEvent> concurrentEventHashMap = new ConcurrentHashMap<>();

    @Data
    protected static class CurrentEvent {

        private BizEvent bizEvent;

        private Boolean isChildEvent;

        private Integer order;

        private Boolean isBlock;

        private Boolean shouldAlarm;

        private Boolean shouldAddRetryCount;

        private Method blockMethod;

    }

    public void await() throws InterruptedException {
        countDownLatch.await();
    }


    public void accomplishOneEvent() {
        countDownLatch.countDown();
    }


    public void putCurrentEvent(BizEvent bizEvent) {
        CurrentEvent currentEvent = new CurrentEvent();
        currentEvent.setBizEvent(bizEvent);
        currentEvent.setOrder(bizEvent.getEventOrder());
        concurrentEventHashMap.put(bizEvent.getBizNo(), currentEvent);
    }

}
