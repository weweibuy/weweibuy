package com.weweibuy.webuy.learning.spring.service;

import com.weweibuy.webuy.learning.spring.annotation.LifeCycle;
import com.weweibuy.webuy.learning.spring.annotation.MyAnnotation;
import com.weweibuy.webuy.learning.spring.model.TestListVo;
import com.weweibuy.webuy.learning.spring.model.eum.BillLifeCycleEum;
import com.weweibuy.webuy.learning.spring.model.eum.BillTypeEum;
import com.weweibuy.webuy.learning.spring.model.eum.ChannelCodeEum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2019/6/11 22:22
 **/
@Slf4j
@Service
@MyAnnotation(channel = ChannelCodeEum.JIT, billType = BillTypeEum.SALE)
public class ATypeInterfaceImpl implements TypeInterface {

    @LifeCycle(lifeCycle = BillLifeCycleEum.CANCEL)
    public void execute(TestListVo testListVo){
        log.error("取消的生命周期: {}", testListVo);
    }

}
