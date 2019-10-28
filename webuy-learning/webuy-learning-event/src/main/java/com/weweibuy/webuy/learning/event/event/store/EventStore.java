package com.weweibuy.webuy.learning.event.event.store;

import com.weweibuy.webuy.learning.event.event.model.BizEventVo;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/10/26 20:14
 **/
public interface EventStore {

    List<BizEventVo> get(Object... args);

    Integer exitEvent(BizEventVo bizEvent);

    void exitEventAndAdd(BizEventVo bizEvent, BizEventVo bizEvent1);

}
