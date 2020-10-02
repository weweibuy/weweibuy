package com.weweibuy.webuy.learning.spring.controller;

import com.weweibuy.framework.common.core.model.dto.CommonCodeResponse;
import com.weweibuy.webuy.learning.spring.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.util.concurrent.Executor;

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

    @Autowired
    private Executor executor;

    /**
     * 返回DeferredResult对象
     *
     * @return
     */
    @RequestMapping("/testDeferredResult")
    public DeferredResult<ResponseEntity> testDeferredResult() {
        DeferredResult<ResponseEntity> deferredResult = new DeferredResult<>();
               executor.execute(() -> {
                   try {
                       Thread.sleep(4000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   deferredResult.setResult(ResponseEntity.ok(CommonCodeResponse.success()));
               });
        return deferredResult;
    }


    @RequestMapping("/testDeferredStream")
    public DeferredResult<ResponseEntity<StreamingResponseBody>> testDeferredStream() {
        DeferredResult<ResponseEntity<StreamingResponseBody>> deferredResult = new DeferredResult<>();
        executor.execute(() -> {
            log.info("异步输出下载流");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            StreamingResponseBody responseBody = outputStream -> {
                log.info("准备输出流");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputStream.write("hello testDeferredResult2".getBytes());
            };
            ResponseEntity<StreamingResponseBody> body = ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generic_file_name.json")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM).body(responseBody);
            deferredResult.setResult(body);

        });
        return deferredResult;
    }



    @GetMapping("/download")
    public ResponseEntity<StreamingResponseBody> handle() {

        log.info("接收到下载请求...");

        StreamingResponseBody responseBody = outputStream -> {
            log.info("输出流...");
            log.info("异步响应输出流...");

            if (false) {
                throw new RuntimeException("下载错误");
            }
            try {
                Thread.sleep(10000);
                outputStream.write("hello StreamingResponseBody".getBytes());
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        };

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generic_file_name.json")
                .contentType(MediaType.APPLICATION_OCTET_STREAM).body(responseBody);
    }

}
