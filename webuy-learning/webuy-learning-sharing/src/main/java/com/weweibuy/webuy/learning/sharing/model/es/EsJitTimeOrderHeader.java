package com.weweibuy.webuy.learning.sharing.model.es;

import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderHeader;
import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author durenhao
 * @date 2019/8/4 21:15
 **/
@Data
@Document(indexName = "time_order", type = "jit_time_order_header", createIndex = false)
public class EsJitTimeOrderHeader {

    private static final BeanCopier BEAN_COPIER = BeanCopier.create(JitTimeOrderHeader.class, EsJitTimeOrderHeader.class, false);


    @Id
    @Field
    private Long id;

    @Field(type = FieldType.keyword, index = false)
    private String timeOrderNo;

    @Field(type = FieldType.keyword, index = false)
    private String warehouseCode;

    @Field(type = FieldType.keyword, index = false)
    private String warehouseName;

    @Field(type = FieldType.keyword, index = false)
    private String vendorCode;

    @Field(type = FieldType.keyword, index = false)
    private String vendorName;

    @Field(type = FieldType.keyword, index = false)
    private String channelCode;

    @Field(type = FieldType.keyword, index = false)
    private String shopBillNo;

    @Field(type = FieldType.keyword, index = false)
    private String orderStatus;

    @Field(type = FieldType.keyword, index = false)
    private String cancelRemark;

    @Field(type = FieldType.Boolean, index = false)
    private Boolean isDelete;

    @Field(type = FieldType.Date, index = false)
    private Date createTime;

    @Field(type = FieldType.Date, index = false)
    private Date updateTime;

    public static EsJitTimeOrderHeader convert(JitTimeOrderHeader jitTimeOrderHeader){
        EsJitTimeOrderHeader esJitTimeOrderHeader = new EsJitTimeOrderHeader();
        BEAN_COPIER.copy(jitTimeOrderHeader, esJitTimeOrderHeader, null);
        esJitTimeOrderHeader.setCreateTime(new Date());
        esJitTimeOrderHeader.setUpdateTime(new Date());
        esJitTimeOrderHeader.setIsDelete(false);
        return esJitTimeOrderHeader;
    }
}
