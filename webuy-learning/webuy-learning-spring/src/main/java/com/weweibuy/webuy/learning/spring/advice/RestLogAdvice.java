package com.weweibuy.webuy.learning.spring.advice;

import com.weweibuy.framework.common.core.utils.JackJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 请求响应日志输出
 *
 * @author durenhao
 * @date 2019/5/19 0:43
 **/
@Slf4j
public class RestLogAdvice implements ResponseBodyAdvice {


//    @Override
//    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
//        return true;
//    }
//
//    @Override
//    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
//        return httpInputMessage;
//    }
//
//    @Override
//    public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
//        log.info("【请求日志】请求体内容: {}", JSON.toJSONString(o));
//        return o;
//    }
//
//    @Override
//    public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
//        log.info("【请求日志】请求体内容: null");
//        return o;
//    }


    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("【响应日志】响应体内容: {}", JackJsonUtils.write(body));
        return "hello";
    }
}
