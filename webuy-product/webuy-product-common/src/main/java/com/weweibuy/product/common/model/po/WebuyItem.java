package com.weweibuy.product.common.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class WebuyItem {
    private Long id;

    private Long itemId;

    private String itemName;

    private String itemTitle;

    private String salePoint;

    private BigDecimal maxPrice;

    private BigDecimal mixPrice;

    private Date onSaleTime;

    private Date offSaleTime;

    private Byte isPromote;

    private BigDecimal promotePrice;

    private Date promoteStartTime;

    private Date promoteEndtTime;

    private Integer saleCount;

    private Long sellerId;

    private Long brandId;

    private Long category1Id;

    private Long category2Id;

    private Long category3Id;

    private String previewImg;

    private String goodsImg;

    private Byte isSpec;

    private Byte isDelete;

    private String itemRemark;

    private Byte status;

    private Date createTime;

    private Date modifyTime;

    private String goodsDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle == null ? null : itemTitle.trim();
    }

    public String getSalePoint() {
        return salePoint;
    }

    public void setSalePoint(String salePoint) {
        this.salePoint = salePoint == null ? null : salePoint.trim();
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMixPrice() {
        return mixPrice;
    }

    public void setMixPrice(BigDecimal mixPrice) {
        this.mixPrice = mixPrice;
    }

    public Date getOnSaleTime() {
        return onSaleTime;
    }

    public void setOnSaleTime(Date onSaleTime) {
        this.onSaleTime = onSaleTime;
    }

    public Date getOffSaleTime() {
        return offSaleTime;
    }

    public void setOffSaleTime(Date offSaleTime) {
        this.offSaleTime = offSaleTime;
    }

    public Byte getIsPromote() {
        return isPromote;
    }

    public void setIsPromote(Byte isPromote) {
        this.isPromote = isPromote;
    }

    public BigDecimal getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(BigDecimal promotePrice) {
        this.promotePrice = promotePrice;
    }

    public Date getPromoteStartTime() {
        return promoteStartTime;
    }

    public void setPromoteStartTime(Date promoteStartTime) {
        this.promoteStartTime = promoteStartTime;
    }

    public Date getPromoteEndtTime() {
        return promoteEndtTime;
    }

    public void setPromoteEndtTime(Date promoteEndtTime) {
        this.promoteEndtTime = promoteEndtTime;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Long category1Id) {
        this.category1Id = category1Id;
    }

    public Long getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Long category2Id) {
        this.category2Id = category2Id;
    }

    public Long getCategory3Id() {
        return category3Id;
    }

    public void setCategory3Id(Long category3Id) {
        this.category3Id = category3Id;
    }

    public String getPreviewImg() {
        return previewImg;
    }

    public void setPreviewImg(String previewImg) {
        this.previewImg = previewImg == null ? null : previewImg.trim();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public Byte getIsSpec() {
        return isSpec;
    }

    public void setIsSpec(Byte isSpec) {
        this.isSpec = isSpec;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getItemRemark() {
        return itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark == null ? null : itemRemark.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }
}