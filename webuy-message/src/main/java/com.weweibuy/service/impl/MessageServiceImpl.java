package com.weweibuy.service.impl;

import com.weweibuy.po.WeweibuyMessage;
import com.weweibuy.po.WeweibuyMessageExample;
import com.weweibuy.service.MessageService;
import com.weweibuy.service.base.impl.BaseServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 消息服务类
 * @ClassName MessageServiceImpl
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 16:10
 **/
@Service
public class MessageServiceImpl  extends BaseServiceImpl<WeweibuyMessage, WeweibuyMessageExample> implements MessageService{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息到 broker, 跟改消息为已发送
     * @param message
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sendMessage(WeweibuyMessage message) {
        WeweibuyMessage message1 = new WeweibuyMessage();
        message1.setStatus((byte)1);
        message1.setId(message.getId());
        updateByPrimaryKeySelective(message1);
        rabbitTemplate.convertAndSend(message.getExchange(), message.getRoutingKey(), message.getBoby(),
                new CorrelationData(message.getDeliverTag()));
    }
}
