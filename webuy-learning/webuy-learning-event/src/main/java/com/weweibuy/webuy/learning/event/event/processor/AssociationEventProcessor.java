package com.weweibuy.webuy.learning.event.event.processor;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.mapper.BizEventMapper;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import com.weweibuy.webuy.learning.event.model.po.BizEventExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/10/26 23:08
 **/
@Slf4j
@Component
public class AssociationEventProcessor extends AbstractLinkedEventProcessor<BizEvent> {

    @Autowired
    private BizEventMapper bizEventMapper;

    @Override
    public void process(EventContext eventContext, BizEvent param) {
        BizEvent eventByPid = getEventByPid(param);
        next(eventContext, param);
    }

    @Override
    public Integer getOrder() {
        return 4;
    }


    public BizEvent getEventByPid(BizEvent bizEvent) {
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
            bizEventList.forEach(e -> {
                getEventByPid(e);
            });
        }
        return bizEvent;
    }

}
