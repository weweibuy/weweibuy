package com.weweibuy.webuy.learning.event.event.store;

import com.weweibuy.webuy.learning.event.event.model.BizEventVo;
import com.weweibuy.webuy.learning.event.mapper.BizEventMapper;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import com.weweibuy.webuy.learning.event.model.po.BizEventExample;
import com.weweibuy.webuy.learning.event.repsitory.BizEventRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<BizEventVo> get(Object... args) {
        BizEventExample bizEventExample = new BizEventExample();

        LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(-30);
        bizEventExample.createCriteria().andIsDeleteEqualTo(false)
                .andParentIdEqualTo("0")
                .andCreateTimeLessThan(localDateTime);
        List<BizEventVo> collect = bizEventMapper.selectByExample(bizEventExample)
                .stream()
                .map(BizEventVo::fromDb)
                .collect(Collectors.toList());
        collect.forEach(this::getEventByParent);
        return collect;
    }


    public BizEventVo getEventByParent(BizEventVo bizEvent) {
        if (bizEvent.getIsParent()) {
            String parentId = bizEvent.getEventNo();
            BizEventExample bizEventExample = new BizEventExample();
            bizEventExample.createCriteria().andIsDeleteEqualTo(false)
                    .andParentIdEqualTo(parentId);
            List<BizEventVo> bizEventList = bizEventMapper.selectByExample(bizEventExample)
                    .stream().map(BizEventVo::fromDb).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(bizEventList)) {
                return bizEvent;
            }

            bizEvent.setChild(bizEventList);
            bizEventList.forEach(this::getEventByParent);
        }
        return bizEvent;
    }


    @Override
    public Integer exitEvent(BizEventVo bizEvent) {
        BizEvent bizEvent1 = bizEvent.toBizEvent();
        return bizEventRepository.delete(bizEvent1);
    }

    @Override
    public void exitEventAndAdd(BizEventVo bizEvent, BizEventVo bizEvent1) {
        bizEventRepository.exitAndNext(bizEvent.toBizEvent(), bizEvent1.toBizEvent());
    }

}
