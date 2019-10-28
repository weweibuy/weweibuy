/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learning.event.event.block;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/10/28 12:22
 **/
@Slf4j
@Component
public class DefaultBlockHandler {

    public void handler() {
        log.info(" 处理阻塞");
    }


}
