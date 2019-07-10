package com.weweibuy.webuy.support.client;

import com.alibaba.fastjson.JSON;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author durenhao
 * @date 2019/6/20 21:45
 **/
@Slf4j
public class MyRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        log.error("请求参数: {}", JSON.toJSONString(template.body()));
    }
}
