package com.weweibuy.webuy.learning.event.event.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.weweibuy.webuy.common.utils.IdWorker;
import com.weweibuy.webuy.learning.event.annotation.EventListenerWarp;
import com.weweibuy.webuy.learning.event.event.model.AddTestBillEvent;
import com.weweibuy.webuy.learning.event.event.model.AddTestBillEvent2;
import com.weweibuy.webuy.learning.event.event.model.BizEventVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/26 11:03
 **/
@Slf4j
@Component
public class TestListener {

    @EventListenerWarp
    public BizEventVo simpleListener(AddTestBillEvent event) {
        log.info("addTestBillEvent  被触发了事件BillNo : {}", event.getBillNo());
        BizEventVo bizEventVo = new BizEventVo();
        bizEventVo.setBizNo("biz_no" + IdWorker.getNextStrId());
        bizEventVo.setEventNo(IdWorker.getNextStrId());
        bizEventVo.setEventType("TEST_TYPE_2");

        AddTestBillEvent2 addTestBillEvent2 = new AddTestBillEvent2();
        addTestBillEvent2.setBillNo("test_2_ bill_no");
        addTestBillEvent2.setBizType("test_2");
        bizEventVo.setBody(addTestBillEvent2);
        bizEventVo.setEventBody(JSON.toJSONString(addTestBillEvent2, SerializerFeature.WriteClassName));

        return null;
    }

    @EventListenerWarp
    public void simpleListener2(AddTestBillEvent2 event) {
        log.info("addTestBillEvent 2  被触发了事件BillNo : {}", event.getBillNo());
    }


}
