package com.weweibuy.webuy.support.client;

import com.weweibuy.webuy.common.model.dto.CommonDataJsonResponse;
import feign.Request;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName SmsCodeClient
 * @Description
 * @Author durenhao
 * @Date 2019/1/19 23:25
 **/
@FeignClient(value = "webuy-support", configuration = {SmsCodeClient.MyOptions.class})
public interface SmsCodeClient {

    @RequestMapping(value = "/smsCode/{mobile}", method = RequestMethod.GET)
    ResponseEntity<CommonDataJsonResponse<String>> getSmsCode(@PathVariable("mobile") String mobile, @RequestHeader(value = "Token") String token);

    @RequestMapping(value = "/smsCode/{mobile}", method = RequestMethod.GET)
    Response getSmsCode2(@PathVariable("mobile") String mobile);


    public class MyOptions extends Request.Options {

        public MyOptions() {
            super(1000, 2000);
        }

    }

}
