package com.weweibuy.user.client;

import com.weweibuy.user.common.model.dto.UserWebResult;
import com.weweibuy.user.common.model.po.WebuyUser;
import com.weweibuy.user.fallback.UserClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName UserClient
 * @Description
 * @Author durenhao
 * @Date 2019/1/13 23:12
 **/
@FeignClient(value = "webuy-user", fallbackFactory = UserClientFallBack.class)
public interface UserClient {

    @RequestMapping(value = "/loadUserByUsername", method = RequestMethod.GET )
    public UserWebResult<WebuyUser> loadUserByUsername(@RequestParam(value = "username") String username);
}
