package com.weweibuy.webuy.message.job;

import com.weweibuy.webuy.message.service.MessageService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.util.ShardingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  用于扫描 还没有收到的消息
 * 1. 下游业务成功,没有收到回复  删除消息
 * 2. 下游业务失败, 重发消息
 * @author durenhao
 * @date 2019/4/11 22:10
 **/
@Slf4j
@Component
@JobHandler(value="messageNotReceiveJob")
public class MessageNotReceiveJob extends IJobHandler {

    @Autowired
    private MessageService messageService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        ShardingUtil.ShardingVO shardingVO = ShardingUtil.getShardingVo();

        return null;
    }
}
