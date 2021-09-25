package com.weweibuy.webuy.learning.drools.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author durenhao
 * @date 2021/9/25 20:46
 **/
@Data
public class CalculateVO {

    private BigDecimal price;

    private BigDecimal qty;


}
