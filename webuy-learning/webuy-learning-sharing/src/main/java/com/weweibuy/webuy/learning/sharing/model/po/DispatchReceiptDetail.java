package com.weweibuy.webuy.learning.sharing.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class DispatchReceiptDetail {
    private Long id;

    private String billNo;

    private String orderNo;

    private String processStatus;

    private String sequence;

    private String barCode;

    private String materialCode;

    private String deliveryCompanyCode;

    private String deliveryExpressBillNo;

    private BigDecimal weight;

    private Integer packageNo;

    private Integer boxNo;

    private Integer amount;

    private Integer estimateTotalAmount;

    private Integer differenceAmount;

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

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence == null ? null : sequence.trim();
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode == null ? null : materialCode.trim();
    }

    public String getDeliveryCompanyCode() {
        return deliveryCompanyCode;
    }

    public void setDeliveryCompanyCode(String deliveryCompanyCode) {
        this.deliveryCompanyCode = deliveryCompanyCode == null ? null : deliveryCompanyCode.trim();
    }

    public String getDeliveryExpressBillNo() {
        return deliveryExpressBillNo;
    }

    public void setDeliveryExpressBillNo(String deliveryExpressBillNo) {
        this.deliveryExpressBillNo = deliveryExpressBillNo == null ? null : deliveryExpressBillNo.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getPackageNo() {
        return packageNo;
    }

    public void setPackageNo(Integer packageNo) {
        this.packageNo = packageNo;
    }

    public Integer getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(Integer boxNo) {
        this.boxNo = boxNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getEstimateTotalAmount() {
        return estimateTotalAmount;
    }

    public void setEstimateTotalAmount(Integer estimateTotalAmount) {
        this.estimateTotalAmount = estimateTotalAmount;
    }

    public Integer getDifferenceAmount() {
        return differenceAmount;
    }

    public void setDifferenceAmount(Integer differenceAmount) {
        this.differenceAmount = differenceAmount;
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