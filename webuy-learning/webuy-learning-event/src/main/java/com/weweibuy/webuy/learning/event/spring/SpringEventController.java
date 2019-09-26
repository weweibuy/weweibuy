package com.weweibuy.webuy.learning.event.spring;

import com.weweibuy.webuy.common.utils.IdWorker;
import com.weweibuy.webuy.learning.event.model.event.biz.BizEventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/9/22 11:53
 **/
@RestController
@RequestMapping("/event")
public class SpringEventController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/jit")
    public Object jitEvent(){
        BizEventVo build = BizEventVo.builder()
                .bizId(IdWorker.getNextStrId())
                .bizType("jit")
                .eventType("receive").build();
        applicationContext.publishEvent(build);
        return "success";
    }

    @RequestMapping("/bbc")
    public Object bbcEvent(){
        BizEventVo build = BizEventVo.builder()
                .bizId(IdWorker.getNextStrId())
                .bizType("bbc")
                .eventType("receive").build();
        applicationContext.publishEvent(build);
        return "success";
    }

    @RequestMapping("/bbc2")
    public Object bbcEvent2(){
        BizEventVo build = BizEventVo.builder()
                .bizId(IdWorker.getNextStrId())
                .bizType("bbc")
                .eventType("dispatch").build();
        applicationContext.publishEvent(build);
        return "success";
    }



}
