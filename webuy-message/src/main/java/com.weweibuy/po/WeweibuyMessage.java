package com.weweibuy.po;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

public class WeweibuyMessage implements Serializable {

    private Long id;

    @NotBlank
    private String deliverTag;

    @NotBlank
    private String boby;

    @NotBlank
    private String queue;

    @NotBlank
    private String exchange;

    private String routingKey;

    private Byte sendTime;

    private Byte isDead;

    private Byte status; //消息状态；0 待确认 2 已发送；3 已消费  默认为 0

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

    public String getDeliverTag() {
        return deliverTag;
    }

    public void setDeliverTag(String deliverTag) {
        this.deliverTag = deliverTag == null ? null : deliverTag.trim();
    }

    public String getBoby() {
        return boby;
    }

    public void setBoby(String boby) {
        this.boby = boby == null ? null : boby.trim();
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue == null ? null : queue.trim();
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange == null ? null : exchange.trim();
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey == null ? null : routingKey.trim();
    }

    public Byte getSendTime() {
        return sendTime;
    }

    public void setSendTime(Byte sendTime) {
        this.sendTime = sendTime;
    }

    public Byte getIsDead() {
        return isDead;
    }

    public void setIsDead(Byte isDead) {
        this.isDead = isDead;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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