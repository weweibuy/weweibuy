package com.weweibuy.webuy.learning.spring.csv.model;

import lombok.Data;

import java.util.Date;

/**
 * @author durenhao
 * @date 2019/7/13 9:50
 **/
@Data
public class InvModel {

    private String companyCode;

    private Date checkDate;

    private String stockCode;

    private String materialCode;

    private String sizeName;

    private String barcode;

    private Integer qty;

    private Integer qtyWj;

}
