package com.weweibuy.webuy.learning.sharing.model.po;

import java.util.Date;

public class DispatchReceipt {
    private Long id;

    private String billNo;

    private String orderNo;

    private Integer receiptIndex;

    private String processStatus;

    private Date deliveryTime;

    private String deliveryName;

    private Date arrivalTime;

    private String deliveryMethod;

    private Integer totalPackageAmount;

    private Integer totalBoxAmount;

    private Integer totalActualShipment;

    private Integer totalRecordNum;

    private Boolean deleted;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getReceiptIndex() {
        return receiptIndex;
    }

    public void setReceiptIndex(Integer receiptIndex) {
        this.receiptIndex = receiptIndex;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName == null ? null : deliveryName.trim();
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod == null ? null : deliveryMethod.trim();
    }

    public Integer getTotalPackageAmount() {
        return totalPackageAmount;
    }

    public void setTotalPackageAmount(Integer totalPackageAmount) {
        this.totalPackageAmount = totalPackageAmount;
    }

    public Integer getTotalBoxAmount() {
        return totalBoxAmount;
    }

    public void setTotalBoxAmount(Integer totalBoxAmount) {
        this.totalBoxAmount = totalBoxAmount;
    }

    public Integer getTotalActualShipment() {
        return totalActualShipment;
    }

    public void setTotalActualShipment(Integer totalActualShipment) {
        this.totalActualShipment = totalActualShipment;
    }

    public Integer getTotalRecordNum() {
        return totalRecordNum;
    }

    public void setTotalRecordNum(Integer totalRecordNum) {
        this.totalRecordNum = totalRecordNum;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}