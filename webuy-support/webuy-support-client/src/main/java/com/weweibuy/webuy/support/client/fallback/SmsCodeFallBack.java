package com.weweibuy.webuy.support.client.fallback;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.framework.common.core.model.eum.CommonErrorCodeEum;
import com.weweibuy.webuy.support.client.SmsCodeClient;
import feign.Response;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            public ResponseEntity<CommonDataResponse<String>> getSmsCode(String mobile, String token) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(CommonDataResponse.response(CommonErrorCodeEum.UNAUTHORIZED, null));
            }

            @Override
            public Response getSmsCode2(String mobile) {
                return null;
            }
        };
    }
}
