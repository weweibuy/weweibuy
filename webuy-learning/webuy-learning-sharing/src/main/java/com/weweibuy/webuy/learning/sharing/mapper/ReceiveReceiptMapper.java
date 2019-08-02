package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.ReceiveReceipt;
import com.weweibuy.webuy.learning.sharing.model.po.ReceiveReceiptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiveReceiptMapper {
    long countByExample(ReceiveReceiptExample example);

    int deleteByExample(ReceiveReceiptExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceiveReceipt record);

    int insertSelective(ReceiveReceipt record);

    List<ReceiveReceipt> selectByExample(ReceiveReceiptExample example);

    ReceiveReceipt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiveReceipt record, @Param("example") ReceiveReceiptExample example);

    int updateByExample(@Param("record") ReceiveReceipt record, @Param("example") ReceiveReceiptExample example);

    int updateByPrimaryKeySelective(ReceiveReceipt record);

    int updateByPrimaryKey(ReceiveReceipt record);
}