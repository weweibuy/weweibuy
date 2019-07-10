package com.weweibuy.webuy.support.client;

import com.weweibuy.webuy.support.common.model.TestUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author durenhao
 * @date 2019/6/26 23:40
 **/
@FeignClient(value = "webuy-support", configuration = {})
public interface TestUserClient {


    @PostMapping("/hello/user")
    public ResponseEntity hello5(TestUser user);

}
