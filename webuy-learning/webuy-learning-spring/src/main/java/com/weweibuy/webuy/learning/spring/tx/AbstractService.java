package com.weweibuy.webuy.learning.spring.tx;

/**
 * @author durenhao
 * @date 2020/8/2 17:41
 **/
public abstract class AbstractService {

    public String biz() {
        return doBiz();
    }


    protected abstract String doBiz();

}
