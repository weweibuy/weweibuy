package com.weweibuy.webuy.learning.sharing.model.po;

import java.util.Date;

public class ReceiveReceipt {
    private Long id;

    private String billNo;

    private String orderNo;

    private Integer receiptIndex;

    private Date receiveTime;

    private Integer totalActualReceipt;

    private String processStatus;

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

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getTotalActualReceipt() {
        return totalActualReceipt;
    }

    public void setTotalActualReceipt(Integer totalActualReceipt) {
        this.totalActualReceipt = totalActualReceipt;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
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