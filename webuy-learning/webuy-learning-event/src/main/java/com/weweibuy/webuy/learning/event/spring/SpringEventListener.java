package com.weweibuy.webuy.learning.event.spring;

import com.weweibuy.webuy.learning.event.annotation.EventListenerWarp;
import com.weweibuy.webuy.learning.event.model.event.biz.BizEventVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/9/22 11:50
 **/
@Slf4j
@Component
public class SpringEventListener {

    @EventListener(condition = "#bizEvent.bizType == 'jit' && #bizEvent.eventType.equals('receive')")
    public void onEvent(BizEventVo bizEvent) {
        log.info("jit + receive 事件发生了: {}", bizEvent);
        throw new RuntimeException("事件错误");
    }

    @EventListenerWarp(condition = "#bizEvent.bizType.equals('bbc') && #bizEvent.eventType.equals('receive')")
    public void onEvent1(BizEventVo bizEvent) {
        log.info("bbc + receive 事件发生了: {}", bizEvent);
    }

    @EventListenerWarp(condition = "#bizEvent.bizType.equals('bbc') && #bizEvent.eventType.equals('dispatch')")
    public BizEventVo onEvent2(BizEventVo bizEvent) {
        log.info("bbc + dispatch 事件发生了 : {}", bizEvent);
        return BizEventVo.builder().bizType("bbc").eventType("receive").build();
    }


}
