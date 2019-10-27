package com.weweibuy.webuy.learning.event.event.advice;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2019/10/27 18:08
 **/
@Component
public class AdviceProcessChainFactory implements InitializingBean {

    @Autowired
    private List<BizEventAdvice> bizEventAdviceList;


    public BizEventAdviceProcessEnter build() {
        BizEventAdviceProcessEnter chain = new BizEventAdviceProcessEnter();
        chain.setPos(0);
        chain.setSize(bizEventAdviceList.size());
        chain.setBizEventAdviceList(bizEventAdviceList);
        return chain;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        bizEventAdviceList = bizEventAdviceList.stream().sorted(Comparator.comparing(BizEventAdvice::getOrder))
                .collect(Collectors.toList());
    }
}
