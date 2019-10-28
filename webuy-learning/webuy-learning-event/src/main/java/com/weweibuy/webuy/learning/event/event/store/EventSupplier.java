package com.weweibuy.webuy.learning.event.event.store;

import com.weweibuy.webuy.learning.event.event.model.BizEventVo;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/10/27 22:12
 **/
public interface EventSupplier {

    List<BizEventVo> get(Object... args);

}
