package com.weweibuy.webuy.learning.sharing.model.po;

import java.util.Date;

public class DispatchBillWarehouseInfo {
    private Long id;

    private Long dispatchBillInfoId;

    private String billNo;

    private String orderNo;

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

    private Boolean deleted;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDispatchBillInfoId() {
        return dispatchBillInfoId;
    }

    public void setDispatchBillInfoId(Long dispatchBillInfoId) {
        this.dispatchBillInfoId = dispatchBillInfoId;
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

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId == null ? null : warehouseId.trim();
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode == null ? null : warehouseCode.trim();
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    public String getBwWarehouseCode() {
        return bwWarehouseCode;
    }

    public void setBwWarehouseCode(String bwWarehouseCode) {
        this.bwWarehouseCode = bwWarehouseCode == null ? null : bwWarehouseCode.trim();
    }

    public Short getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseType(Short warehouseType) {
        this.warehouseType = warehouseType;
    }

    public String getInterWarehouseId() {
        return interWarehouseId;
    }

    public void setInterWarehouseId(String interWarehouseId) {
        this.interWarehouseId = interWarehouseId == null ? null : interWarehouseId.trim();
    }

    public String getInterWarehouseCode() {
        return interWarehouseCode;
    }

    public void setInterWarehouseCode(String interWarehouseCode) {
        this.interWarehouseCode = interWarehouseCode == null ? null : interWarehouseCode.trim();
    }

    public String getInterWarehouseName() {
        return interWarehouseName;
    }

    public void setInterWarehouseName(String interWarehouseName) {
        this.interWarehouseName = interWarehouseName == null ? null : interWarehouseName.trim();
    }

    public Short getInterWarehouseType() {
        return interWarehouseType;
    }

    public void setInterWarehouseType(Short interWarehouseType) {
        this.interWarehouseType = interWarehouseType;
    }

    public Date getExpectOutTime() {
        return expectOutTime;
    }

    public void setExpectOutTime(Date expectOutTime) {
        this.expectOutTime = expectOutTime;
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType == null ? null : expressType.trim();
    }

    public Boolean getFreightModeFlag() {
        return freightModeFlag;
    }

    public void setFreightModeFlag(Boolean freightModeFlag) {
        this.freightModeFlag = freightModeFlag;
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