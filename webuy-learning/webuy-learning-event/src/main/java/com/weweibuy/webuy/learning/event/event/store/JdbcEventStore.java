package com.weweibuy.webuy.learning.event.event.store;

import com.weweibuy.webuy.learning.event.event.trigger.TriggerType;
import com.weweibuy.webuy.learning.event.mapper.BizEventMapper;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import com.weweibuy.webuy.learning.event.model.po.BizEventExample;
import com.weweibuy.webuy.learning.event.repsitory.BizEventRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/10/26 20:13
 **/
@Component
public class JdbcEventStore implements EventStore, EventSupplier {

    @Autowired
    private BizEventMapper bizEventMapper;

    @Autowired
    private BizEventRepository bizEventRepository;

    @Override
    public List<BizEvent> get(Object... args) {
        BizEventExample bizEventExample = new BizEventExample();
        bizEventExample.createCriteria().andIsDeleteEqualTo(false)
                .andParentIdEqualTo("0");
        List<BizEvent> bizEvents = bizEventMapper.selectByExample(bizEventExample);
        bizEvents.stream().peek(e -> e.setTriggerType(TriggerType.JOB_JDBC))
                .forEach(this::getEventByParent);
        return bizEvents;
    }


    public BizEvent getEventByParent(BizEvent bizEvent) {
        if (bizEvent.getIsParent()) {
            String parentId = bizEvent.getEventNo();
            BizEventExample bizEventExample = new BizEventExample();
            bizEventExample.createCriteria().andIsDeleteEqualTo(false)
                    .andParentIdEqualTo(parentId);
            List<BizEvent> bizEventList = bizEventMapper.selectByExample(bizEventExample);
            if (CollectionUtils.isEmpty(bizEventList)) {
                return bizEvent;
            }
            bizEvent.setChild(bizEventList);
            bizEventList.stream().peek(e -> e.setTriggerType(TriggerType.JOB_JDBC))
                    .forEach(this::getEventByParent);
        }
        return bizEvent;
    }


    @Override
    public Integer exitEvent(BizEvent bizEvent) {
        return bizEventRepository.delete(bizEvent);
    }

    @Override
    public void exitEventAndAdd(BizEvent bizEvent, BizEvent bizEvent1) {
        bizEventRepository.exitAndNext(bizEvent, bizEvent1);
    }

}
