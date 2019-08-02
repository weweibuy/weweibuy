package com.weweibuy.webuy.support.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author durenhao
 * @date 2019/6/26 23:40
 **/
@FeignClient(value = "webuy-support", configuration = {})
public interface TestUserClient {



}
