package com.weweibuy.test;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

/**
 * @ClassName TaskTest
 * @Description
 * @Author durenhao
 * @Date 2018/10/18 22:21
 **/
@JobHandler(value="helloXxlJob")
@Component
public class TaskTest extends IJobHandler{


    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.err.println("Hello XXL");
        return null;
    }
}
