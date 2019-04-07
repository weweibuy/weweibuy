package com.weweibuy.webuy.learning.spring.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName DutyService
 * @Description
 * @Author durenhao
 * @Date 2019/3/16 22:15
 **/
@Slf4j
@Component
public class DutyService implements ApplicationListener<Duty>{

    @Autowired
    private DutyDispatch dutyDispatch;

    @Async
    @Override
    public void onApplicationEvent(Duty event) {
        log.error("现在有活干了。。。");
        Duty duty = dutyDispatch.pollDuty();
        if(duty == null){
            log.error("任务限流,无法获取任务");
            return;
        }
        try {
            doBiz(duty);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doBiz(Duty duty) throws InterruptedException {
        log.error("DutyService .. do .. my .. biz");
        log.error("duty is {}  这个任务我要花10s", duty.toString());
        Thread.sleep(10000);
        log.error("任务 {} 已经搞完了", duty);
        dutyDispatch.finishWork(duty);
    }

}
