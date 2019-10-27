package com.weweibuy.webuy.learning.event.job;

import com.weweibuy.webuy.learning.event.event.EventProcessorEngine;
import com.weweibuy.webuy.learning.event.event.store.EventSupplier;
import com.weweibuy.webuy.learning.event.event.store.JdbcEventStore;
import com.weweibuy.webuy.learning.event.event.trigger.BizEventTrigger;
import com.weweibuy.webuy.learning.event.event.trigger.TriggerType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/23 22:12
 **/
@Slf4j
@Component
public class EventTriggerJob implements InitializingBean, BizEventTrigger {

    @Autowired
    private EventProcessorEngine eventProcessorEngine;

    @Autowired
    private JdbcEventStore jdbcEventStore;

    @Scheduled(cron = "*/30 * * * * ?")
    public void triggerEvent() throws Exception {
        log.info("job 开始了");
        trigger(TriggerType.JOB_JDBC, jdbcEventStore);
        log.info("job 结束了");

    }


    @Override
    public void afterPropertiesSet() throws Exception {
    }

    @Override
    public void trigger(TriggerType triggerType, EventSupplier supplier) throws Exception {
        eventProcessorEngine.process(triggerType, supplier);
    }
}
