package com.weweibuy.webuy.message.service.impl;

import com.netflix.discovery.converters.Auto;
import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.common.model.po.WebuyMessageExample;
import com.weweibuy.webuy.message.service.MessageAckManager;
import com.weweibuy.webuy.message.service.MessageService;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/4/9 22:43
 **/
@Component
public class MessageAckManagerImpl implements MessageAckManager {

    @Auto
    private MessageService messageService;

    @Override
    @Retryable(backoff = @Backoff(50))
    @Transactional(rollbackFor = Exception.class)
    public void execMessageNack(String messageCorrelationId) {
        WebuyMessageExample example = new WebuyMessageExample();
        example.createCriteria()
            .andMessageCorrelationIdEqualTo(messageCorrelationId);
        List<WebuyMessage> list = messageService.selectByExample(example);
        if(list.get(0) != null){
            WebuyMessage message = list.get(0);
            Byte sendTime = message.getMessageSendTime();
            if(sendTime != 3){
                return;
            }else {
                messageService.deadMessages(messageCorrelationId);
            }
        }
    }


}
