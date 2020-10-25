package com.weweibuy.webuy.learning.flowable.client;

import com.weweibuy.upms.api.user.GroupQueryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author durenhao
 * @date 2020/10/25 11:38
 **/
@FeignClient(name = "groupClient", contextId = "groupClient", url = "http://localhost:8060")
public interface GroupClient extends GroupQueryApi {
}
