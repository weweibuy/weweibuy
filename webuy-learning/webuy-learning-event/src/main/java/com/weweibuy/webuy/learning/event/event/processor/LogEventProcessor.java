package com.weweibuy.webuy.learning.event.event.processor;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.event.model.BizEventVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/10/26 21:55
 **/
@Slf4j
@Component
public class LogEventProcessor extends AbstractLinkedEventProcessor<List<BizEventVo>> {


    @Override
    public void process(EventContext eventContext, List<BizEventVo> param) {
        log.info("LogEventProcessor running ... ");
        next(eventContext, param);
    }

    @Override
    public Integer getOrder() {
        return 0;
    }
}
