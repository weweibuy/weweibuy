package com.weweibuy.order.common.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class OrderShipping {
    private Long id;

    private Long orderId;

    private Long trackingNumber;

    private Long shippingMethodId;

    private Long shippingAddresId;

    private String shippingMethodName;

    private BigDecimal shippingFee;

    private Byte isInsurance;

    private BigDecimal insuranceFee;

    private Byte shippingStatus;

    private Date shipingStartTime;

    private Date shipingEndTime;

    private Date createTime;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(Long trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Long getShippingMethodId() {
        return shippingMethodId;
    }

    public void setShippingMethodId(Long shippingMethodId) {
        this.shippingMethodId = shippingMethodId;
    }

    public Long getShippingAddresId() {
        return shippingAddresId;
    }

    public void setShippingAddresId(Long shippingAddresId) {
        this.shippingAddresId = shippingAddresId;
    }

    public String getShippingMethodName() {
        return shippingMethodName;
    }

    public void setShippingMethodName(String shippingMethodName) {
        this.shippingMethodName = shippingMethodName == null ? null : shippingMethodName.trim();
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Byte getIsInsurance() {
        return isInsurance;
    }

    public void setIsInsurance(Byte isInsurance) {
        this.isInsurance = isInsurance;
    }

    public BigDecimal getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(BigDecimal insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public Byte getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(Byte shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public Date getShipingStartTime() {
        return shipingStartTime;
    }

    public void setShipingStartTime(Date shipingStartTime) {
        this.shipingStartTime = shipingStartTime;
    }

    public Date getShipingEndTime() {
        return shipingEndTime;
    }

    public void setShipingEndTime(Date shipingEndTime) {
        this.shipingEndTime = shipingEndTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}