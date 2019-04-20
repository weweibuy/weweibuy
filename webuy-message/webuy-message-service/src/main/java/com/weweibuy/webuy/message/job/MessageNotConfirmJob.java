package com.weweibuy.webuy.message.job;

import com.weweibuy.webuy.message.service.MessageConfirmService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.util.ShardingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 未确认消息job
 * 用于扫描 还没有确认的消息
 * 1.上游业务成功, 有对应记录;则发送消息
 * 2.上游业务失败, 无对应记录;删除消息
 *
 * @author durenhao
 * @date 2019/4/10 22:32
 **/
@Slf4j
@Component
@JobHandler(value="messageNotConfirmJob")
public class MessageNotConfirmJob extends IJobHandler{

    @Autowired
    private MessageConfirmService messageConfirmService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        ShardingUtil.ShardingVO shardingVO = ShardingUtil.getShardingVo();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return null;
    }
}
