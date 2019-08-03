package com.weweibuy.webuy.learning.spring.model.po;

import java.util.Date;

public class DispatchBillInfo {
    private Long id;

    private String billNo;

    private String orderNo;

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

    public String getSourceBilllNo() {
        return sourceBilllNo;
    }

    public void setSourceBilllNo(String sourceBilllNo) {
        this.sourceBilllNo = sourceBilllNo == null ? null : sourceBilllNo.trim();
    }

    public String getManualBillNo() {
        return manualBillNo;
    }

    public void setManualBillNo(String manualBillNo) {
        this.manualBillNo = manualBillNo == null ? null : manualBillNo.trim();
    }

    public String getPrefinishBillNo() {
        return prefinishBillNo;
    }

    public void setPrefinishBillNo(String prefinishBillNo) {
        this.prefinishBillNo = prefinishBillNo == null ? null : prefinishBillNo.trim();
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

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getBatchMark() {
        return batchMark;
    }

    public void setBatchMark(String batchMark) {
        this.batchMark = batchMark == null ? null : batchMark.trim();
    }

    public Integer getDispatchReason() {
        return dispatchReason;
    }

    public void setDispatchReason(Integer dispatchReason) {
        this.dispatchReason = dispatchReason;
    }

    public Date getExpectArrivalTime() {
        return expectArrivalTime;
    }

    public void setExpectArrivalTime(Date expectArrivalTime) {
        this.expectArrivalTime = expectArrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
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

    public Integer getTotalActualShipment() {
        return totalActualShipment;
    }

    public void setTotalActualShipment(Integer totalActualShipment) {
        this.totalActualShipment = totalActualShipment;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getPrintInvoiceFlag() {
        return printInvoiceFlag;
    }

    public void setPrintInvoiceFlag(Boolean printInvoiceFlag) {
        this.printInvoiceFlag = printInvoiceFlag;
    }

    public Boolean getWithInvoiceFlag() {
        return withInvoiceFlag;
    }

    public void setWithInvoiceFlag(Boolean withInvoiceFlag) {
        this.withInvoiceFlag = withInvoiceFlag;
    }

    public Boolean getAllowReceiptFlag() {
        return allowReceiptFlag;
    }

    public void setAllowReceiptFlag(Boolean allowReceiptFlag) {
        this.allowReceiptFlag = allowReceiptFlag;
    }

    public Boolean getAllowPartialDeliveryFlag() {
        return allowPartialDeliveryFlag;
    }

    public void setAllowPartialDeliveryFlag(Boolean allowPartialDeliveryFlag) {
        this.allowPartialDeliveryFlag = allowPartialDeliveryFlag;
    }

    public Boolean getDispatchImmediatelyFlag() {
        return dispatchImmediatelyFlag;
    }

    public void setDispatchImmediatelyFlag(Boolean dispatchImmediatelyFlag) {
        this.dispatchImmediatelyFlag = dispatchImmediatelyFlag;
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