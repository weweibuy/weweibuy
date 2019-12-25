package com.weweibuy.webuy.learning.spring.bean;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/12/24 23:26
 **/
@RestController
public class MyCacheUser {

    private final IValue myCacheBean;


    public MyCacheUser(IValue myCacheBean) {
        this.myCacheBean = myCacheBean;
    }


    @RequestMapping("/test/bean")
    public Object getValue(){
        return myCacheBean.getValue();
    }
}
