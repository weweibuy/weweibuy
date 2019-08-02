package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillWarehouseInfo;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillWarehouseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DispatchBillWarehouseInfoMapper {
    long countByExample(DispatchBillWarehouseInfoExample example);

    int deleteByExample(DispatchBillWarehouseInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DispatchBillWarehouseInfo record);

    int insertSelective(DispatchBillWarehouseInfo record);

    List<DispatchBillWarehouseInfo> selectByExample(DispatchBillWarehouseInfoExample example);

    DispatchBillWarehouseInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DispatchBillWarehouseInfo record, @Param("example") DispatchBillWarehouseInfoExample example);

    int updateByExample(@Param("record") DispatchBillWarehouseInfo record, @Param("example") DispatchBillWarehouseInfoExample example);

    int updateByPrimaryKeySelective(DispatchBillWarehouseInfo record);

    int updateByPrimaryKey(DispatchBillWarehouseInfo record);
}