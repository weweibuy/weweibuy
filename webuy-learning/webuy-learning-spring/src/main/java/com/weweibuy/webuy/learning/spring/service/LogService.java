package com.weweibuy.webuy.learning.spring.service;

import com.weweibuy.webuy.learning.spring.model.event.LogEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2019/11/15 22:49
 **/
@Service
public class LogService {



    @EventListener
    public void onLog(LogEvent event){

    }



}
