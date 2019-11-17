package com.weweibuy.webuy.learning.spring.model.event;

import lombok.Builder;
import lombok.Data;

/**
 * @author durenhao
 * @date 2019/11/15 22:43
 **/
@Data
@Builder
public class LogEvent {

    private String path;

    private String userName;

    private Long time;

}
