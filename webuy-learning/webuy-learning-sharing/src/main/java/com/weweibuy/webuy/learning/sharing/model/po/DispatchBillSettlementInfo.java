package com.weweibuy.webuy.learning.sharing.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class DispatchBillSettlementInfo {
    private Long id;

    private Long dispatchBillInfoId;

    private String billNo;

    private String orderNo;

    private Date paymentTime;

    private Short paymentType;

    private BigDecimal collectionAmount;

    private BigDecimal payAmount;

    private BigDecimal expressAmount;

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

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Short getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Short paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getCollectionAmount() {
        return collectionAmount;
    }

    public void setCollectionAmount(BigDecimal collectionAmount) {
        this.collectionAmount = collectionAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getExpressAmount() {
        return expressAmount;
    }

    public void setExpressAmount(BigDecimal expressAmount) {
        this.expressAmount = expressAmount;
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