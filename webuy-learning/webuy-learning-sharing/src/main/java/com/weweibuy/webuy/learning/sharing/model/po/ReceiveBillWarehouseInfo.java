package com.weweibuy.webuy.learning.sharing.model.po;

import java.util.Date;

public class ReceiveBillWarehouseInfo {
    private Long id;

    private Long receiveBillInfoId;

    private String billNo;

    private String orderNo;

    private String receiveWarehouseId;

    private String receiveWarehouseCode;

    private String receiveWarehouseName;

    private String bwReceiveWarehouseCode;

    private Short receiveWarehouseType;

    private String expressBillNo;

    private String freightCompanyCode;

    private String transportMethodCode;

    private String transportMethodName;

    private String allocateType;

    private String allocatePriority;

    private String allocateModeCode;

    private String allocateModeName;

    private String deliveryWarehouseId;

    private String deliveryWarehouseCode;

    private String deliveryWarehouseName;

    private String bwDeliveryWarehouseCode;

    private Short deliveryWarehouseType;

    private Boolean deleted;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReceiveBillInfoId() {
        return receiveBillInfoId;
    }

    public void setReceiveBillInfoId(Long receiveBillInfoId) {
        this.receiveBillInfoId = receiveBillInfoId;
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

    public String getReceiveWarehouseId() {
        return receiveWarehouseId;
    }

    public void setReceiveWarehouseId(String receiveWarehouseId) {
        this.receiveWarehouseId = receiveWarehouseId == null ? null : receiveWarehouseId.trim();
    }

    public String getReceiveWarehouseCode() {
        return receiveWarehouseCode;
    }

    public void setReceiveWarehouseCode(String receiveWarehouseCode) {
        this.receiveWarehouseCode = receiveWarehouseCode == null ? null : receiveWarehouseCode.trim();
    }

    public String getReceiveWarehouseName() {
        return receiveWarehouseName;
    }

    public void setReceiveWarehouseName(String receiveWarehouseName) {
        this.receiveWarehouseName = receiveWarehouseName == null ? null : receiveWarehouseName.trim();
    }

    public String getBwReceiveWarehouseCode() {
        return bwReceiveWarehouseCode;
    }

    public void setBwReceiveWarehouseCode(String bwReceiveWarehouseCode) {
        this.bwReceiveWarehouseCode = bwReceiveWarehouseCode == null ? null : bwReceiveWarehouseCode.trim();
    }

    public Short getReceiveWarehouseType() {
        return receiveWarehouseType;
    }

    public void setReceiveWarehouseType(Short receiveWarehouseType) {
        this.receiveWarehouseType = receiveWarehouseType;
    }

    public String getExpressBillNo() {
        return expressBillNo;
    }

    public void setExpressBillNo(String expressBillNo) {
        this.expressBillNo = expressBillNo == null ? null : expressBillNo.trim();
    }

    public String getFreightCompanyCode() {
        return freightCompanyCode;
    }

    public void setFreightCompanyCode(String freightCompanyCode) {
        this.freightCompanyCode = freightCompanyCode == null ? null : freightCompanyCode.trim();
    }

    public String getTransportMethodCode() {
        return transportMethodCode;
    }

    public void setTransportMethodCode(String transportMethodCode) {
        this.transportMethodCode = transportMethodCode == null ? null : transportMethodCode.trim();
    }

    public String getTransportMethodName() {
        return transportMethodName;
    }

    public void setTransportMethodName(String transportMethodName) {
        this.transportMethodName = transportMethodName == null ? null : transportMethodName.trim();
    }

    public String getAllocateType() {
        return allocateType;
    }

    public void setAllocateType(String allocateType) {
        this.allocateType = allocateType == null ? null : allocateType.trim();
    }

    public String getAllocatePriority() {
        return allocatePriority;
    }

    public void setAllocatePriority(String allocatePriority) {
        this.allocatePriority = allocatePriority == null ? null : allocatePriority.trim();
    }

    public String getAllocateModeCode() {
        return allocateModeCode;
    }

    public void setAllocateModeCode(String allocateModeCode) {
        this.allocateModeCode = allocateModeCode == null ? null : allocateModeCode.trim();
    }

    public String getAllocateModeName() {
        return allocateModeName;
    }

    public void setAllocateModeName(String allocateModeName) {
        this.allocateModeName = allocateModeName == null ? null : allocateModeName.trim();
    }

    public String getDeliveryWarehouseId() {
        return deliveryWarehouseId;
    }

    public void setDeliveryWarehouseId(String deliveryWarehouseId) {
        this.deliveryWarehouseId = deliveryWarehouseId == null ? null : deliveryWarehouseId.trim();
    }

    public String getDeliveryWarehouseCode() {
        return deliveryWarehouseCode;
    }

    public void setDeliveryWarehouseCode(String deliveryWarehouseCode) {
        this.deliveryWarehouseCode = deliveryWarehouseCode == null ? null : deliveryWarehouseCode.trim();
    }

    public String getDeliveryWarehouseName() {
        return deliveryWarehouseName;
    }

    public void setDeliveryWarehouseName(String deliveryWarehouseName) {
        this.deliveryWarehouseName = deliveryWarehouseName == null ? null : deliveryWarehouseName.trim();
    }

    public String getBwDeliveryWarehouseCode() {
        return bwDeliveryWarehouseCode;
    }

    public void setBwDeliveryWarehouseCode(String bwDeliveryWarehouseCode) {
        this.bwDeliveryWarehouseCode = bwDeliveryWarehouseCode == null ? null : bwDeliveryWarehouseCode.trim();
    }

    public Short getDeliveryWarehouseType() {
        return deliveryWarehouseType;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeliveryWarehouseType(Short deliveryWarehouseType) {
        this.deliveryWarehouseType = deliveryWarehouseType;
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