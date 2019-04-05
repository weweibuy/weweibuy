package com.weweibuy.webuy.support.client.fallback;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.support.client.SmsCodeClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName SmsCodeFallBack
 * @Description
 * @Author durenhao
 * @Date 2019/1/20 13:13
 **/
@Slf4j
@Component
public class SmsCodeFallBack implements FallbackFactory<SmsCodeClient> {

    @Override
    public SmsCodeClient create(Throwable throwable) {
        log.error(throwable.getMessage());
        return new SmsCodeClient() {

            @Override
            public CommonJsonResponse<String> getSmsCode(String mobile) {
                return new CommonJsonResponse<String>("FALL", 0, "cuowu", null);
            }
        };
    }
}
