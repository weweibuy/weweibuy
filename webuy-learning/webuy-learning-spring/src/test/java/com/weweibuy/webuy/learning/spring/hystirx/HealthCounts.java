package com.weweibuy.webuy.learning.spring.hystirx;

import lombok.Data;

/**
 * @author durenhao
 * @date 2019/6/1 23:06
 **/
@Data
public class HealthCounts {

    private long totalCount;

    private long errorCount;

    private int errorPercentage;


}
