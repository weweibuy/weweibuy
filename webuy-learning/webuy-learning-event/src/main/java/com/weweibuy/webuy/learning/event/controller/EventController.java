package com.weweibuy.webuy.learning.event.controller;

import com.weweibuy.framework.common.core.utils.IdWorker;
import com.weweibuy.webuy.learning.event.event.config.EventTypeEum;
import com.weweibuy.webuy.learning.event.event.helper.BizEventHelper;
import com.weweibuy.webuy.learning.event.event.model.AddTestBillEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/10/26 10:40
 **/
@RestController
@RequestMapping("/event/test")
public class EventController {
    @GetMapping("/add")
    public String addNewEvent(){
        AddTestBillEvent addTestBillEvent = new AddTestBillEvent();
        addTestBillEvent.setBillNo("billNo_" + IdWorker.nextStringId());
        addTestBillEvent.setBillType("receive");
        addTestBillEvent.setWhType("WH1111");
        addTestBillEvent.setBizType("B2B");
        BizEventHelper.save("test_" + IdWorker.nextStringId(), addTestBillEvent, EventTypeEum.TEST_EVENT);
        return "success";
    }


}
