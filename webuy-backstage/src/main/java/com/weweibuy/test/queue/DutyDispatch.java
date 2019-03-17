package com.weweibuy.test.queue;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName DutyDispatch
 * @Description
 * @Author durenhao
 * @Date 2019/3/16 22:17
 **/
@Slf4j
@Service
public class DutyDispatch {

    private ArrayBlockingQueue<Duty> arrayBlockingQueue = new ArrayBlockingQueue<Duty>(10);

    private ConcurrentHashMap<Duty, String> workMap = new ConcurrentHashMap<>(32);

    private RateLimiter rateLimiter = RateLimiter.create(0.2);

    @Autowired
    private ApplicationContext applicationContext;


    public boolean pushDuty(Duty duty){
        arrayBlockingQueue.offer(duty);
        log.error("DutyDispatch... 存储任务");
        applicationContext.publishEvent(new Duty("客户端的任务x"));
        return true;
    }

    public Duty pollDuty(){
        boolean b = rateLimiter.tryAcquire();
        if(!b){
            log.error("不要把service 累死了!!!");
            return null;
        }
        Duty duty = arrayBlockingQueue.poll();
        workMap.put(duty, "1");
        return duty;
    }

    public boolean prepareWork(Duty duty){
        if(workMap.containsKey(duty) || arrayBlockingQueue.contains(duty)){
            return false;
        }
        pushDuty(duty);
        return true;
    }

    public void finishWork(Duty duty){
        if(duty != null){
            workMap.remove(duty);
        }
        DutyComplete dutyComplete = new DutyComplete("");
        BeanUtils.copyProperties(duty, dutyComplete);
        applicationContext.publishEvent(dutyComplete);
        doNextWork();
    }

    public void doNextWork(){
        log.error("准备干下一件事。。。。");
        if(arrayBlockingQueue.size() > 0){
            applicationContext.publishEvent(new Duty(""));
        }
    }

}
