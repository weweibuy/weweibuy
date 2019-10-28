package com.weweibuy.webuy.learning.event.event.processor;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.model.BizEventVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author durenhao
 * @date 2019/10/26 21:56
 **/
@Slf4j
@Component
public class ThreadPoolEventProcessor extends AbstractLinkedEventProcessor<List<BizEventVo>> {

    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(10, 10,
            60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(100), new CustomizableThreadFactory("event-thread-"));


    @Override
    public void process(EventContext eventContext, List<BizEventVo> param) {
        log.info("ThreadPoolEventProcessor running ...");
        param.forEach(e -> {
            EXECUTOR_SERVICE.submit(() -> {
                try {
                    next(eventContext, e);
                } finally {
                    eventContext.accomplishOneEvent();
                }
            });
        });
    }

    @Override
    public Integer getOrder() {
        return 10;
    }


}
