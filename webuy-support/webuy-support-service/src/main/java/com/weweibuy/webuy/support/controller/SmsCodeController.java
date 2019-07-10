package com.weweibuy.webuy.support.controller;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.common.eum.CommonStatus;
import com.weweibuy.webuy.support.service.SmsCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SmsCodeController
 * @Description
 * @Author durenhao
 * @Date 2019/1/19 22:32
 **/
@Slf4j
@Api("手机验证码")
@RestController("/support")
public class SmsCodeController {

    @Autowired
    private SmsCodeService smsCodeService;

    @ApiOperation("获取验证码")
    @GetMapping("/smsCode/{mobile}")
    public ResponseEntity getSmsCode(@PathVariable String mobile, @RequestHeader(value = "Token") String token) throws InterruptedException {
        log.error(" token : {}", token);

        if (true) {
            Thread.sleep(50);
            return ResponseEntity.badRequest().body(CommonJsonResponse.success());
        }

        if (StringUtils.isBlank(mobile)) {
            return ResponseEntity.ok(new CommonJsonResponse<String>(CommonStatus.FAIL.toString(), null, null, null));
        }
        return ResponseEntity.ok(new CommonJsonResponse<String>(CommonStatus.SUCCESS.toString(), null, null,
                smsCodeService.getSmsCode(mobile)));
    }

}
