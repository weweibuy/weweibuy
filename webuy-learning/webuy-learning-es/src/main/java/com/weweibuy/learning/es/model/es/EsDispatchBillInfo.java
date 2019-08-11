package com.weweibuy.learning.es.model.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author durenhao
 * @date 2019/8/11 9:36
 **/
@Data
@Document(indexName = "dispatch_bill_info", type = "dispatch_bill_info", createIndex = false)
public class EsDispatchBillInfo {

    @Id
    private String billNo;

    private String orderNo;

    private String bizFlowNo;

    private String billType;

    private String bizType;

    private String billSource;

    private String billStatus;

    private String processStatus;

    private String channelCode;

    private String sourceBilllNo;

    private String manualBillNo;

    private String prefinishBillNo;

    private String vendcustId;

    private String vendcustCode;

    private String vendcustName;

    private String batchNo;

    private String batchMark;

    private Integer dispatchReason;

    private Date expectArrivalTime;

    private Date departureTime;

    private String shopBillNo;

    private String buyerUserName;

    private String province;

    private String city;

    private String area;

    private String address;

    private String contact;

    private String phone;

    private Integer expectAmount;

    private Integer totalRecordNum;

    private Integer totalActualShipment;

    private String remark;

    private Boolean printInvoiceFlag;

    private Boolean withInvoiceFlag;

    private Boolean allowReceiptFlag;

    private Boolean allowPartialDeliveryFlag;

    private Boolean dispatchImmediatelyFlag;

    // ====================================

    private Long tb_warehouse_info_id;

    private String warehouseId;

    private String warehouseCode;

    private String warehouseName;

    private String bwWarehouseCode;

    private Short warehouseType;

    private String interWarehouseId;

    private String interWarehouseCode;

    private String interWarehouseName;

    private Short interWarehouseType;

    private Date expectOutTime;

    private String expressType;

    private Boolean freightModeFlag;

    private String expressBillNo;

    private String freightCompanyCode;

    private String transportMethodCode;

    private String transportMethodName;

    private String allocateType;

    private String allocatePriority;

    private String allocateModeCode;

    private String allocateModeName;

    // ======================

    private Long tb_settlement_info_id;

    private Date paymentTime;

    private Short paymentType;

    private BigDecimal collectionAmount;

    private BigDecimal payAmount;

    private BigDecimal expressAmount;

    private Date createTime;

    private Date updateTime;


}
