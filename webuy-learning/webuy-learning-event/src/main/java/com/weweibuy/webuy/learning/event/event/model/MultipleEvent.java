package com.weweibuy.webuy.learning.event.event.model;

import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/10/26 23:16
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultipleEvent {

    private BizEvent parent;

    private List<MultipleEvent> child;
}
