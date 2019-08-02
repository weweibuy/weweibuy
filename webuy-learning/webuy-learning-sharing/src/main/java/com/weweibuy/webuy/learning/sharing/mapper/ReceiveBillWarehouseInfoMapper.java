package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.ReceiveBillWarehouseInfo;
import com.weweibuy.webuy.learning.sharing.model.po.ReceiveBillWarehouseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiveBillWarehouseInfoMapper {
    long countByExample(ReceiveBillWarehouseInfoExample example);

    int deleteByExample(ReceiveBillWarehouseInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceiveBillWarehouseInfo record);

    int insertSelective(ReceiveBillWarehouseInfo record);

    List<ReceiveBillWarehouseInfo> selectByExample(ReceiveBillWarehouseInfoExample example);

    ReceiveBillWarehouseInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiveBillWarehouseInfo record, @Param("example") ReceiveBillWarehouseInfoExample example);

    int updateByExample(@Param("record") ReceiveBillWarehouseInfo record, @Param("example") ReceiveBillWarehouseInfoExample example);

    int updateByPrimaryKeySelective(ReceiveBillWarehouseInfo record);

    int updateByPrimaryKey(ReceiveBillWarehouseInfo record);
}