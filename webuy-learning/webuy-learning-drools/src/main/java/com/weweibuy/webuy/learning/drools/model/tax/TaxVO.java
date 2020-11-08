package com.weweibuy.webuy.learning.drools.model.tax;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author durenhao
 * @date 2020/11/6 21:36
 **/
@Data
public class TaxVO {

    /**
     * 收入
     */
    private BigDecimal income;

    /**
     * 应交税金额
     */
    private BigDecimal shouldTaxAmount;

    /**
     * 税率
     */
    private BigDecimal taxRatio;

    /**
     * 免除金额
     */
    private BigDecimal deductAmount;

    /**
     * 交税额
     */
    private BigDecimal taxAmount;

    /**
     * 税后
     */
    private BigDecimal taxedIncome;

}
