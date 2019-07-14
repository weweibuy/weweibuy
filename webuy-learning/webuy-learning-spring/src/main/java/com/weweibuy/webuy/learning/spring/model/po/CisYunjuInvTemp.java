package com.weweibuy.webuy.learning.spring.model.po;

import java.util.Date;

public class CisYunjuInvTemp {
    private Long id;

    private String productNo;

    private String materialCode;

    private String sizeName;

    private String warehouseCode;

    private String externalWarehouseCode;

    private Integer qty;

    private String checkingState;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode == null ? null : materialCode.trim();
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName == null ? null : sizeName.trim();
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode == null ? null : warehouseCode.trim();
    }

    public String getExternalWarehouseCode() {
        return externalWarehouseCode;
    }

    public void setExternalWarehouseCode(String externalWarehouseCode) {
        this.externalWarehouseCode = externalWarehouseCode == null ? null : externalWarehouseCode.trim();
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getCheckingState() {
        return checkingState;
    }

    public void setCheckingState(String checkingState) {
        this.checkingState = checkingState == null ? null : checkingState.trim();
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