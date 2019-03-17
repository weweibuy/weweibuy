package com.weweibuy.test.queue;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PushDutyController
 * @Description
 * @Author durenhao
 * @Date 2019/3/16 22:14
 **/
@Slf4j
@RestController
public class PushDutyController {

    @Autowired
    private DutyDispatch dutyDispatch;

    @GetMapping("/push/duty")
    public String pushDuty(Long id, String name, HttpServletRequest request){
        Duty duty = new Duty("客户端的任务x", id, name, request.getRemoteAddr());
        boolean b = dutyDispatch.prepareWork(duty);
        if(!b){
            log.error("任务 {} 已经加入任务, 不要重复加入。。。", duty);
            return "已经加入任务,不要重复加入";
        }
       return "success";
    }


}
