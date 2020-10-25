package com.weweibuy.webuy.learning.flowable.client;

import com.weweibuy.upms.api.user.UserQueryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author durenhao
 * @date 2020/10/25 11:38
 **/
@FeignClient(name = "userClient",contextId = "userClient", url = "http://localhost:8060")
public interface UserClient extends UserQueryApi {
}
