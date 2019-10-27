package com.weweibuy.webuy.learning.event.event.store;

import com.weweibuy.webuy.learning.event.mapper.BizEventMapper;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import com.weweibuy.webuy.learning.event.model.po.BizEventExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/10/26 20:13
 **/
@Component
public class JdbcEventStore implements EventStore {

    @Autowired
    private BizEventMapper bizEventMapper;

    @Override
    public List<BizEvent> getEvent(Object... args) {
        BizEventExample bizEventExample = new BizEventExample();
        bizEventExample.createCriteria().andIsDeleteEqualTo(false)
                .andParentIdEqualTo("0");
        List<BizEvent> bizEvents = bizEventMapper.selectByExample(bizEventExample);
        return bizEvents;
    }

    @Override
    public Integer exitEvent(BizEvent bizEvent) {
        return null;
    }

    @Override
    public Integer exitEventAndAdd(BizEvent bizEvent, BizEvent bizEvent1) {
        return null;
    }
}
