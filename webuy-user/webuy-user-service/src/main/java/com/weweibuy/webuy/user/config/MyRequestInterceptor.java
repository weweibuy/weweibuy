package com.weweibuy.webuy.user.config;

import com.weweibuy.framework.common.core.utils.JackJsonUtils;
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
        log.error("请求参数: {}", JackJsonUtils.write(template.body()));
    }
}
