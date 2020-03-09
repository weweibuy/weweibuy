package com.weweibuy.webuy.auth.mq;

import com.weweibuy.framework.rocketmq.annotation.RocketProvider;
import com.weweibuy.framework.rocketmq.annotation.RocketProviderHandler;
import com.weweibuy.webuy.auth.mq.message.ServerChangeMessage;

/**
 * @author durenhao
 * @date 2020/3/9 21:43
 **/
@RocketProvider(topic = "SERVER_CHANGE_TOPIC")
public interface ServerDownMqProvider {

    @RocketProviderHandler
    void sendServerDownMessage(ServerChangeMessage message);


}
