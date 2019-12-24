package com.weweibuy.webuy.learning.spring.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author durenhao
 * @date 2019/12/24 23:09
 **/
@Slf4j
public class MyCacheBean implements IValue{

    public String getValue() {
        log.info("查询数据!");
        return "hello";
    }

}
