package com.weweibuy.webuy.user.client;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.webuy.user.client.fallback.UserClientFallBack;
import com.weweibuy.webuy.user.common.model.po.WebuyUser;
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
    public CommonDataResponse<WebuyUser> loadUserByUsername(@RequestParam(value = "username") String username);
}
