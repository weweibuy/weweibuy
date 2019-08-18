package com.weweibuy.webuy.support.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * @author durenhao
 * @date 2019/6/26 23:40
 **/
@FeignClient(value = "webuy-support")
public interface TestUserClient {

    @GetMapping("/test/users")
    String getUsers(@RequestParam("userList") Set<String> userList);

}
