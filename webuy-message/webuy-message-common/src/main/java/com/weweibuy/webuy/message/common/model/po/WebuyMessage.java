package com.weweibuy.webuy.message.common.model.po;

import java.util.Date;

public class WebuyMessage {
    private Long id;

    private Long messageCorrelationId;

    private String messageBoby;

    private String messageQueue;

    private String messageExchange;

    private String messageRoutingKey;

    private Byte messageSendTime;

    private Byte isDead;

    private Byte messageStatus;

    private String field1;

    private String field2;

    private String field3;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMessageCorrelationId() {
        return messageCorrelationId;
    }

    public void setMessageCorrelationId(Long messageCorrelationId) {
        this.messageCorrelationId = messageCorrelationId;
    }

    public String getMessageBoby() {
        return messageBoby;
    }

    public void setMessageBoby(String messageBoby) {
        this.messageBoby = messageBoby == null ? null : messageBoby.trim();
    }

    public String getMessageQueue() {
        return messageQueue;
    }

    public void setMessageQueue(String messageQueue) {
        this.messageQueue = messageQueue == null ? null : messageQueue.trim();
    }

    public String getMessageExchange() {
        return messageExchange;
    }

    public void setMessageExchange(String messageExchange) {
        this.messageExchange = messageExchange == null ? null : messageExchange.trim();
    }

    public String getMessageRoutingKey() {
        return messageRoutingKey;
    }

    public void setMessageRoutingKey(String messageRoutingKey) {
        this.messageRoutingKey = messageRoutingKey == null ? null : messageRoutingKey.trim();
    }

    public Byte getMessageSendTime() {
        return messageSendTime;
    }

    public void setMessageSendTime(Byte messageSendTime) {
        this.messageSendTime = messageSendTime;
    }

    public Byte getIsDead() {
        return isDead;
    }

    public void setIsDead(Byte isDead) {
        this.isDead = isDead;
    }

    public Byte getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Byte messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
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