package com.weweibuy.webuy.message.amqp;

import com.weweibuy.webuy.message.common.model.po.WebuyMessage;

/**
 * @author durenhao
 * @date 2019/2/8 23:21
 **/
public interface MessageSender {

    void send(WebuyMessage message);


}
