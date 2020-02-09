package com.weweibuy.learning.es.model.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Date;

/**
 * @author durenhao
 * @date 2019/8/4 21:15
 **/
@Data
@Document(indexName = "time_order", type = "jit_time_order_header", createIndex = false)
public class EsJitTimeOrderHeader {


    @Id
    @Field
    private Long id;

    private String timeOrderNo;

    private String warehouseCode;

    private String warehouseName;

    private String vendorCode;

    private String vendorName;

    private String channelCode;

    private String shopBillNo;

    private String orderStatus;

    private String cancelRemark;

    private Boolean isDelete;

    private Date createTime;

    private Date updateTime;

}
