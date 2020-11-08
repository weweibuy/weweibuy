package com.weweibuy.webuy.learning.drools.uils;

import java.math.BigDecimal;

/**
 * @author durenhao
 * @date 2020/11/6 22:48
 **/
public class TaxUtils {

    public static BigDecimal computeTax(BigDecimal shouldTaxAmount, BigDecimal deductAmount, BigDecimal taxRatio) {
        return shouldTaxAmount.subtract(deductAmount).multiply(taxRatio);
    }

    public static BigDecimal computeTaxedIncome(BigDecimal income, BigDecimal taxAmount) {
        return income.subtract(taxAmount);
    }


}
