package com.weweibuy.webuy.learning.spring.model;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class ResponseVoTest {

    @Test
    public void test(){
        String json = "{\"code\":\"12\", \"msg\":\"QAZ\"}";
        ResponseVo responseVo = JSON.parseObject(json, ResponseVo.class);
        System.err.println(responseVo);

    }

}