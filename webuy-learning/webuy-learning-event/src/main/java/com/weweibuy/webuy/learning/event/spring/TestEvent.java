package com.weweibuy.webuy.learning.event.spring;

import lombok.Builder;
import lombok.Data;

/**
 * @author durenhao
 * @date 2019/11/17 10:38
 **/
@Data
@Builder
public class TestEvent {

    private String bizType;

    private Long id;
}
