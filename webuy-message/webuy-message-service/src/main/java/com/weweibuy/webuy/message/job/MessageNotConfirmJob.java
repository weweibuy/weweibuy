package com.weweibuy.webuy.message.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
@Service
@JobHandler(value="messageNotConfirmJob")
public class MessageNotConfirmJob extends IJobHandler{

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        return null;
    }
}
