package com.weweibuy.user.fallback;

import com.weweibuy.user.client.UserClient;
import com.weweibuy.user.common.eum.UserWebMsgEum;
import com.weweibuy.user.common.model.dto.UserWebResult;
import com.weweibuy.user.common.model.po.WebuyUser;
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
            public UserWebResult<WebuyUser> loadUserByUsername(String username) {
                return UserWebResult.fail(UserWebMsgEum.UNKNOWN_WRONG);
            }
        };
    }
}
