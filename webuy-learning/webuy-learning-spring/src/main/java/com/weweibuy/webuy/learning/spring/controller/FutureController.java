package com.weweibuy.webuy.learning.spring.controller;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.learning.spring.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author durenhao
 * @date 2019/8/13 23:00
 **/
@Slf4j
@RestController
@RequestMapping("/future")
public class FutureController {

    @Autowired
    private AsyncService asyncService;

    private DeferredResult<ResponseEntity> deferredResult = new DeferredResult<>();

    /**
     * 返回DeferredResult对象
     *
     * @return
     */
    @RequestMapping("/testDeferredResult")
    public DeferredResult<ResponseEntity> testDeferredResult() {
//        if(true){
//        throw new RuntimeException("发生异常");
//        }
        return deferredResult;
    }

    /**
     * 对DeferredResult的结果进行设置
     * @return
     */
    @RequestMapping("/setDeferredResult")
    public String setDeferredResult() {
        deferredResult.setResult(ResponseEntity.ok(CommonJsonResponse.success("请求成功了")));
        return "succeed";
    }

}
