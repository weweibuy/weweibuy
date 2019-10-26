package com.weweibuy.webuy.learning.event.job;

import com.weweibuy.webuy.learning.event.event.EventProcessorEngine;
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
public class EventTriggerJob implements InitializingBean {

    @Autowired
    private EventProcessorEngine eventProcessorEngine;

    @Scheduled(cron = "*/30 * * * * ?")
    public void triggerEvent() throws InterruptedException {
        log.info("job 开始了");
        eventProcessorEngine.process();
        log.info("job 结束了");

    }


    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
