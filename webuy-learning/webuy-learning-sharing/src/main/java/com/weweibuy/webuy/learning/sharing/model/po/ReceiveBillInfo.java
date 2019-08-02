package com.weweibuy.webuy.learning.sharing.model.po;

import java.util.Date;

public class ReceiveBillInfo {
    private Long id;

    private String billNo;

    private String orderNo;

    private String bizFlowNo;

    private String billType;

    private String bizType;

    private Boolean refundReason;

    private Date expectTime;

    private Date departureTime;

    private String billSource;

    private String billStatus;

    private String processStatus;

    private String channelCode;

    private String dispatchBillNo;

    private String vendcustId;

    private String vendcustCode;

    private String vendcustName;

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

    private Integer totalActualReceipt;

    private String remark;

    private Boolean allowReceiptFlag;

    private Boolean dispatchImmediatelyFlag;

    private Boolean refundInvoiceFlag;

    private Integer shardingKey;

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

    public String getBizFlowNo() {
        return bizFlowNo;
    }

    public void setBizFlowNo(String bizFlowNo) {
        this.bizFlowNo = bizFlowNo == null ? null : bizFlowNo.trim();
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public Boolean getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(Boolean refundReason) {
        this.refundReason = refundReason;
    }

    public Date getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Date expectTime) {
        this.expectTime = expectTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getBillSource() {
        return billSource;
    }

    public void setBillSource(String billSource) {
        this.billSource = billSource == null ? null : billSource.trim();
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus == null ? null : billStatus.trim();
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getDispatchBillNo() {
        return dispatchBillNo;
    }

    public void setDispatchBillNo(String dispatchBillNo) {
        this.dispatchBillNo = dispatchBillNo == null ? null : dispatchBillNo.trim();
    }

    public String getVendcustId() {
        return vendcustId;
    }

    public void setVendcustId(String vendcustId) {
        this.vendcustId = vendcustId == null ? null : vendcustId.trim();
    }

    public String getVendcustCode() {
        return vendcustCode;
    }

    public void setVendcustCode(String vendcustCode) {
        this.vendcustCode = vendcustCode == null ? null : vendcustCode.trim();
    }

    public String getVendcustName() {
        return vendcustName;
    }

    public void setVendcustName(String vendcustName) {
        this.vendcustName = vendcustName == null ? null : vendcustName.trim();
    }

    public String getShopBillNo() {
        return shopBillNo;
    }

    public void setShopBillNo(String shopBillNo) {
        this.shopBillNo = shopBillNo == null ? null : shopBillNo.trim();
    }

    public String getBuyerUserName() {
        return buyerUserName;
    }

    public void setBuyerUserName(String buyerUserName) {
        this.buyerUserName = buyerUserName == null ? null : buyerUserName.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getExpectAmount() {
        return expectAmount;
    }

    public void setExpectAmount(Integer expectAmount) {
        this.expectAmount = expectAmount;
    }

    public Integer getTotalRecordNum() {
        return totalRecordNum;
    }

    public void setTotalRecordNum(Integer totalRecordNum) {
        this.totalRecordNum = totalRecordNum;
    }

    public Integer getTotalActualReceipt() {
        return totalActualReceipt;
    }

    public void setTotalActualReceipt(Integer totalActualReceipt) {
        this.totalActualReceipt = totalActualReceipt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getAllowReceiptFlag() {
        return allowReceiptFlag;
    }

    public void setAllowReceiptFlag(Boolean allowReceiptFlag) {
        this.allowReceiptFlag = allowReceiptFlag;
    }

    public Boolean getDispatchImmediatelyFlag() {
        return dispatchImmediatelyFlag;
    }

    public void setDispatchImmediatelyFlag(Boolean dispatchImmediatelyFlag) {
        this.dispatchImmediatelyFlag = dispatchImmediatelyFlag;
    }

    public Boolean getRefundInvoiceFlag() {
        return refundInvoiceFlag;
    }

    public void setRefundInvoiceFlag(Boolean refundInvoiceFlag) {
        this.refundInvoiceFlag = refundInvoiceFlag;
    }

    public Integer getShardingKey() {
        return shardingKey;
    }

    public void setShardingKey(Integer shardingKey) {
        this.shardingKey = shardingKey;
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