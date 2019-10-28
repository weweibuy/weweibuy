package com.weweibuy.webuy.learning.event.event.processor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.model.BizEventVo;
import com.weweibuy.webuy.learning.event.event.trigger.TriggerType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/26 22:00
 **/
@Slf4j
@Component
public class ApplicationEventPushEventProcessor extends AbstractLinkedEventProcessor<BizEventVo> {

    private final static ParserConfig defaultRedisConfig = new ParserConfig();

    static {
        defaultRedisConfig.setAutoTypeSupport(true);
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void process(EventContext eventContext, BizEventVo param) {
        log.info("ApplicationEventPushEventProcessor  is running ....");
        TriggerType triggerType = param.getTriggerType();
        switch (triggerType) {
            case APPLICATION:
                if (param.getBody() != null) {
                    applicationContext.publishEvent(param.getBody());
                }
                break;
            default:
                if (StringUtils.isNotBlank(param.getEventBody())) {
                    Object parse = JSON.parse(param.getEventBody(), defaultRedisConfig);
                    applicationContext.publishEvent(parse);
                }
        }
        next(eventContext, param);
    }

    @Override
    public Integer getOrder() {
        return Integer.MAX_VALUE;
    }

}
