package com.weweibuy.webuy.product.common.model.po;

import java.util.Date;

public class PropertyOption {
    private Long id;

    private Long propertyId;

    private String optionName;

    private Integer optionSortNo;

    private String optionPic;

    private Date createTime;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName == null ? null : optionName.trim();
    }

    public Integer getOptionSortNo() {
        return optionSortNo;
    }

    public void setOptionSortNo(Integer optionSortNo) {
        this.optionSortNo = optionSortNo;
    }

    public String getOptionPic() {
        return optionPic;
    }

    public void setOptionPic(String optionPic) {
        this.optionPic = optionPic == null ? null : optionPic.trim();
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