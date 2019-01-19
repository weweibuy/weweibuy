package com.weweibuy.support.client;

import com.weweibuy.dto.CommonJsonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName SmsCodeClient
 * @Description
 * @Author durenhao
 * @Date 2019/1/19 23:25
 **/
@FeignClient("webuy-support")
public interface SmsCodeClient {

    @RequestMapping(value = "/smsCode/{mobile}", method = RequestMethod.GET)
    public CommonJsonResponse<String> getSmsCode(@PathVariable String mobile);

}
