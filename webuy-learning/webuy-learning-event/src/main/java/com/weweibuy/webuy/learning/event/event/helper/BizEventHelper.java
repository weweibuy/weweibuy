package com.weweibuy.webuy.learning.event.event.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.weweibuy.webuy.common.utils.IdWorker;
import com.weweibuy.webuy.learning.event.event.config.EventConfig;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import com.weweibuy.webuy.learning.event.repsitory.BizEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author durenhao
 * @date 2019/10/26 9:45
 **/
@Component
public class BizEventHelper {

    @Autowired
    private BizEventRepository repository;

    private static BizEventRepository bizEventRepository;


    @PostConstruct
    public void init(){
        bizEventRepository = repository;
    }

    public static void save(String bizNo, Object eventBody, EventConfig eventConfig){
        BizEvent bizEvent = new BizEvent();
        bizEvent.setEventType(eventConfig.getEventType());
        bizEvent.setBizNo(bizNo);
        bizEvent.setEventBody(JSON.toJSONString(eventBody, SerializerFeature.WriteClassName));
        bizEvent.setEventNo(IdWorker.getNextStrId());
        bizEventRepository.insert(bizEvent);
    }


    public static void exit(BizEvent bizEvent){
        bizEventRepository.delete(bizEvent);
    }

    public static void exitAndNext(BizEvent exit, BizEvent next){
        bizEventRepository.exitAndNext(exit, next);
    }

}
