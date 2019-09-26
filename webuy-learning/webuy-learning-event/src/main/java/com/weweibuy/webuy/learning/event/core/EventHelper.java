package com.weweibuy.webuy.learning.event.core;

import com.weweibuy.webuy.learning.event.mapper.BizEventMapper;
import com.weweibuy.webuy.learning.event.model.event.biz.BizEventVo;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author durenhao
 * @date 2019/9/22 20:49
 **/
@Component
public class EventHelper {

    private final BizEventMapper bizEventMapper;

    public EventHelper(BizEventMapper bizEventMapper) {
        this.bizEventMapper = bizEventMapper;
    }

    public void finishAndNext(BizEventVo finish, BizEventVo... next) {
        Long id = finish.getId();
        bizEventMapper.deleteByPrimaryKey(id);
        if (next != null && next.length > 0) {
            Arrays.stream(next)
                    .forEach(n -> bizEventMapper.insertSelective(BizEventVo.toBizEvent(n)));
        }
    }




}
