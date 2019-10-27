package com.weweibuy.webuy.learning.event.event.processor;

import com.weweibuy.webuy.learning.event.event.context.EventContext;
import com.weweibuy.webuy.learning.event.mapper.BizEventMapper;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        flatTree(eventContext, Collections.singletonList(param));
    }

    private void flatTree(EventContext eventContext, List<BizEvent> categoryModels) {
        for (BizEvent categoryModel : categoryModels) {
            List<BizEvent> children = categoryModel.getChild();
            if (CollectionUtils.isNotEmpty(children)) {
                // 子事件不为空; 继续收集子事件
                List<BizEvent> collect = children.stream().sorted(Comparator.comparing(BizEvent::getEventOrder)).collect(Collectors.toList());
                flatTree(eventContext, collect);
            }
            // 没有子事件发送事件体
            if (StringUtils.isNotBlank(categoryModel.getEventBody())) {
                next(eventContext, categoryModel);
            }
        }
    }


    @Override
    public Integer getOrder() {
        return 40;
    }

}
