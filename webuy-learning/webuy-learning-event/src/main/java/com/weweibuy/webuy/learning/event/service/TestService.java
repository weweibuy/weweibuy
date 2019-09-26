package com.weweibuy.webuy.learning.event.service;

import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2019/9/21 21:56
 **/
@Service
public class TestService {

    @EventListener
    public void test01(BizEvent event){

    }


}
