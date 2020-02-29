package com.weweibuy.webuy.user.client.fallback;

import com.weweibuy.webuy.common.model.dto.CommonDataJsonResponse;
import com.weweibuy.webuy.user.client.UserClient;
import com.weweibuy.webuy.user.common.model.po.WebuyUser;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserClientFallBack
 * @Description
 * @Author durenhao
 * @Date 2019/1/20 12:49
 **/
@Slf4j
@Lazy
@Component
public class UserClientFallBack implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable throwable) {
        log.error(throwable.getMessage());
        return new UserClient() {
            @Override
            public CommonDataJsonResponse<WebuyUser> loadUserByUsername(String username) {
                return null;
            }
        };
    }
}
