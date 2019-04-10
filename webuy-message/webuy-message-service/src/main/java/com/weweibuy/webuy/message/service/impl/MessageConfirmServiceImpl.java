package com.weweibuy.webuy.message.service.impl;

import com.weweibuy.webuy.message.service.MessageConfirmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2019/4/10 23:04
 **/
@Slf4j
@Service
public class MessageConfirmServiceImpl implements MessageConfirmService {

    /**
     * 时间间隔
     */
    private static final Long CONFIRM_TIME = 60L;

    @Override
    public void confirmToUpstream() {
        /*
         * 1.扫表 取出 当前时间 - 创建时间 > CONFIRM_TIME的待确认消息
         * 2.调用上游确认地址 ---> 消息表事物成功记录(id, correlationId, 队列交换机 等),不删除消息
         * 3.上游不存在则删除; 存在则发送
         *
         */

    }

    @Override
    public void confirmToDownstream() {
         /*
         * 1.扫表 取出 当前时间 - 修改时间 > CONFIRM_TIME的已发送消息
         * 2.调用下游确认地址
         * 3.下游不成功则重发??? ---> 下游根据消息id 判断业务是否已经成功执行 ---> 消息表事物成功记录(id, correlationId, 交换机),不删除消息
         *    成功则删除,不成功判断发送次数,进行重发
         *
         */

    }
}
