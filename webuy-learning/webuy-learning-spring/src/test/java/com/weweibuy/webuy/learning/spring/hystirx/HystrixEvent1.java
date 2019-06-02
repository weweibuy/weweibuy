package com.weweibuy.webuy.learning.spring.hystirx;

import lombok.Builder;
import lombok.Data;

/**
 * @author durenhao
 * @date 2019/6/1 23:10
 **/
@Data
@Builder
public class HystrixEvent1 {

    private long startTimestamp;

    private int executionLatency; //time spent in run() method

    private int userThreadLatency;

}
