package com.weweibuy.webuy.learning.event.event.processor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/26 22:00
 **/
@Slf4j
@Component
public class ApplicationEventPushEventProcessor extends AbstractLinkedEventProcessor<BizEvent> {


    private final static ParserConfig defaultRedisConfig = new ParserConfig();

    static {
        defaultRedisConfig.setAutoTypeSupport(true);
    }


    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void process(EventContext eventContext, BizEvent param) {
        log.info("ApplicationEventPushEventProcessor  is running ....");
        Object parse = JSON.parse(param.getEventBody(), defaultRedisConfig);
        applicationContext.publishEvent(parse);
        next(eventContext, param);
    }

    @Override
    public Integer getOrder() {
        return Integer.MAX_VALUE;
    }

}
