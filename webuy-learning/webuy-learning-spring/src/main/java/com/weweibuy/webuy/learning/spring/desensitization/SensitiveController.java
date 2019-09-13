package com.weweibuy.webuy.learning.spring.desensitization;

import com.weweibuy.webuy.learning.spring.desensitization.vo.SensitiveUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/9/12 22:24
 **/
@Slf4j
@RestController
@RequestMapping("/sensitive")
public class SensitiveController {

    @PostMapping("/user")
    public SensitiveUser test01(@RequestBody SensitiveUser user) {
        log.info("用户: {}", user);
        return user;
    }

}
