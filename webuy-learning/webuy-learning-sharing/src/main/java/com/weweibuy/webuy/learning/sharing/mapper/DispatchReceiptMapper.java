package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.DispatchReceipt;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchReceiptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DispatchReceiptMapper {
    long countByExample(DispatchReceiptExample example);

    int deleteByExample(DispatchReceiptExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DispatchReceipt record);

    int insertSelective(DispatchReceipt record);

    List<DispatchReceipt> selectByExample(DispatchReceiptExample example);

    DispatchReceipt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DispatchReceipt record, @Param("example") DispatchReceiptExample example);

    int updateByExample(@Param("record") DispatchReceipt record, @Param("example") DispatchReceiptExample example);

    int updateByPrimaryKeySelective(DispatchReceipt record);

    int updateByPrimaryKey(DispatchReceipt record);
}