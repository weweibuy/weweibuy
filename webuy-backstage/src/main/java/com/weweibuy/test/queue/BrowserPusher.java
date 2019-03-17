package com.weweibuy.test.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName BrowserPusher
 * @Description
 * @Author durenhao
 * @Date 2019/3/17 21:06
 **/
@Slf4j
@Component
public class BrowserPusher implements ApplicationListener<DutyComplete> {

    @Autowired
    private SocketServer socketServer;

    @Async
    @Override
    public void onApplicationEvent(DutyComplete event) {
        log.error("准备把  {} 完成事件返回浏览器", event);
        SocketMessageInfo socketMessageInfo = new SocketMessageInfo();
        socketMessageInfo.setMessage(event.toString() + "已经完成");
        socketMessageInfo.setSessionKey(event.getSessionKey());
        SocketServer.sendMessage(socketMessageInfo);
    }




}
