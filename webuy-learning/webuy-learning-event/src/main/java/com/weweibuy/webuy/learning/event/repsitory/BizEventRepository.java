package com.weweibuy.webuy.learning.event.repsitory;

import com.weweibuy.webuy.learning.event.mapper.BizEventMapper;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import com.weweibuy.webuy.learning.event.model.po.BizEventExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author durenhao
 * @date 2019/10/26 9:51
 **/
@Repository
public class BizEventRepository {


    @Autowired
    private BizEventMapper bizEventMapper;

    public Integer insert(BizEvent bizEvent) {
        return bizEventMapper.insertSelective(bizEvent);
    }


    public Integer delete(BizEvent bizEvent) {
        Long id = bizEvent.getId();
        if (id != null) {
            BizEvent bizEvent1 = new BizEvent();
            bizEvent1.setId(bizEvent.getId());
            bizEvent1.setIsDelete(true);
            return bizEventMapper.updateByPrimaryKeySelective(bizEvent1);
        } else {
            String eventNo = bizEvent.getEventNo();
            BizEventExample bizEventExample = new BizEventExample();
            bizEventExample.createCriteria().andEventNoEqualTo(eventNo);
            BizEvent bizEvent1 = new BizEvent();
            bizEvent1.setIsDelete(true);
            return bizEventMapper.updateByExampleSelective(bizEvent1, bizEventExample);
        }

    }


    @Transactional(rollbackFor = Exception.class)
    public void exitAndNext(BizEvent exit, BizEvent next) {
        BizEvent bizEvent1 = new BizEvent();
        bizEvent1.setId(exit.getId());
        bizEvent1.setIsDelete(true);
        bizEventMapper.updateByPrimaryKeySelective(bizEvent1);
        bizEventMapper.insertSelective(next);
    }

}
