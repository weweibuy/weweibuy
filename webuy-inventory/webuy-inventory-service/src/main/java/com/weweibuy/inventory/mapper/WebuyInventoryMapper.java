package com.weweibuy.inventory.mapper;

import com.weweibuy.inventory.common.model.po.WebuyInventory;
import com.weweibuy.inventory.common.model.po.WebuyInventoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebuyInventoryMapper {
    long countByExample(WebuyInventoryExample example);

    int deleteByExample(WebuyInventoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WebuyInventory record);

    int insertSelective(WebuyInventory record);

    List<WebuyInventory> selectByExample(WebuyInventoryExample example);

    WebuyInventory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WebuyInventory record, @Param("example") WebuyInventoryExample example);

    int updateByExample(@Param("record") WebuyInventory record, @Param("example") WebuyInventoryExample example);

    int updateByPrimaryKeySelective(WebuyInventory record);

    int updateByPrimaryKey(WebuyInventory record);
}