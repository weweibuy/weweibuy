package com.weweibuy.webuy.auth.mq;

import com.weweibuy.framework.rocketmq.annotation.RocketProducer;
import com.weweibuy.framework.rocketmq.annotation.RocketProducerHandler;
import com.weweibuy.webuy.auth.mq.message.ServerChangeMessage;

/**
 * @author durenhao
 * @date 2020/3/9 21:43
 **/
@RocketProducer(topic = "SERVER_CHANGE_TOPIC")
public interface ServerDownMqProvider {

    @RocketProducerHandler
    void sendServerDownMessage(ServerChangeMessage message);


}
