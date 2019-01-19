package com.weweibuy.support.controller;

import com.weweibuy.dto.CommonJsonResponse;
import com.weweibuy.eum.CommonStatus;
import com.weweibuy.support.service.SmsCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SmsCodeController
 * @Description
 * @Author durenhao
 * @Date 2019/1/19 22:32
 **/
@Api("手机验证码")
@RestController("/support")
public class SmsCodeController {

    @Autowired
    private SmsCodeService smsCodeService;

    @ApiOperation("获取验证码")
    @GetMapping("/smsCode/{mobile}")
    public CommonJsonResponse<String> getSmsCode(@PathVariable String mobile){
        if(StringUtils.isBlank(mobile)){
            return new CommonJsonResponse<String>(CommonStatus.FAIL.toString(), null, null, null);
        }
        return new CommonJsonResponse<String>(CommonStatus.SUCCESS.toString(), null, null,
                smsCodeService.getSmsCode(mobile));
    }

}
