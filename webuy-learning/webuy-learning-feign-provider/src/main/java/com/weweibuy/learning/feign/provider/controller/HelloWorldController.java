package com.weweibuy.learning.feign.provider.controller;

import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author durenhao
 * @date 2019/12/24 21:33
 **/
@Slf4j
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public CommonDataResponse<String> helloGet() {
        return CommonDataResponse.success("hello i am provider get method");
    }


    @PostMapping("/hello")
    public CommonDataResponse<String> helloPost(@RequestBody CommonDataResponse<String> commonJsonResponse,
                                                    @RequestHeader(value = "token") String token,
                                                    String sign) {
        log.info("date : {}", commonJsonResponse.getData());
        log.info("token : {}", token);
        log.info("sign : {}", sign);
        if (true) {
            throw Exceptions.unknown();
        }
        return CommonDataResponse.success("hello i am provider post method");
    }

    @PostMapping("/hello-file")
    public ResponseEntity<StreamingResponseBody> helloFile(MultipartFile file, String name, HttpServletResponse response) throws IOException {
        InputStream inputStream = file.getInputStream();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + name)
                .body(outputStream ->
                {
                    byte[] buf = new byte[1024];
                    int len = 0;
                    while ((len = inputStream.read(buf)) != -1) {
                        outputStream.write(buf);
                    }
                });

    }

}
