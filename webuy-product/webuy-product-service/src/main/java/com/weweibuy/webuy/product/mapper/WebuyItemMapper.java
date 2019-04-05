package com.weweibuy.webuy.product.mapper;

import com.weweibuy.webuy.product.common.model.po.WebuyItem;
import com.weweibuy.webuy.product.common.model.po.WebuyItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebuyItemMapper {
    long countByExample(WebuyItemExample example);

    int deleteByExample(WebuyItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WebuyItem record);

    int insertSelective(WebuyItem record);

    List<WebuyItem> selectByExampleWithBLOBs(WebuyItemExample example);

    List<WebuyItem> selectByExample(WebuyItemExample example);

    WebuyItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WebuyItem record, @Param("example") WebuyItemExample example);

    int updateByExampleWithBLOBs(@Param("record") WebuyItem record, @Param("example") WebuyItemExample example);

    int updateByExample(@Param("record") WebuyItem record, @Param("example") WebuyItemExample example);

    int updateByPrimaryKeySelective(WebuyItem record);

    int updateByPrimaryKeyWithBLOBs(WebuyItem record);

    int updateByPrimaryKey(WebuyItem record);
}