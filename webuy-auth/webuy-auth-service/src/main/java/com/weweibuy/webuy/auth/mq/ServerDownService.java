package com.weweibuy.webuy.auth.mq;

import com.weweibuy.framework.rocketmq.annotation.Payload;
import com.weweibuy.framework.rocketmq.annotation.RocketConsumerHandler;
import com.weweibuy.framework.rocketmq.annotation.RocketListener;
import com.weweibuy.webuy.auth.mq.message.ServerChangeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2020/3/9 21:46
 **/
@Slf4j
@Service
@RocketListener(topic = "SERVER_CHANGE_TOPIC", group = "AUTH_C_SERVER_CHANGE_TOPIC")
public class ServerDownService implements DisposableBean {

    @Autowired
    private ServerDownMqProvider serverDownMqProvider;

    @Autowired
    private Environment environment;

    @RocketConsumerHandler
    public void update(@Payload ServerChangeMessage changeMessage) {
        log.info("接受到服务变更消息");
    }

    @Override
    public void destroy() throws Exception {
        log.info("执行destroy 方法");
        ServerChangeMessage serverChangeMessage = new ServerChangeMessage();
        serverChangeMessage.setName(environment.getProperty("spring.application.name"));
        serverChangeMessage.setInstanceId(environment.getProperty("spring.cloud.consul.discovery.instance-id"));
        serverDownMqProvider.sendServerDownMessage(serverChangeMessage);
    }
}
