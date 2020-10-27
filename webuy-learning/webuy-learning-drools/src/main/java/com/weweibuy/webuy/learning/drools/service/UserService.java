package com.weweibuy.webuy.learning.drools.service;

import com.weweibuy.webuy.learning.drools.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2020/10/27 22:42
 **/
@Slf4j
@Service
public class UserService {

    public void logUser(User user) {
        log.info("用户信息: {}", user);
    }


}
