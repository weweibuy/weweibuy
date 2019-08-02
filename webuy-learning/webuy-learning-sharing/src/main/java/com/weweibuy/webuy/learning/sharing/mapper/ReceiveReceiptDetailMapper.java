package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.ReceiveReceiptDetail;
import com.weweibuy.webuy.learning.sharing.model.po.ReceiveReceiptDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiveReceiptDetailMapper {
    long countByExample(ReceiveReceiptDetailExample example);

    int deleteByExample(ReceiveReceiptDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceiveReceiptDetail record);

    int insertSelective(ReceiveReceiptDetail record);

    List<ReceiveReceiptDetail> selectByExample(ReceiveReceiptDetailExample example);

    ReceiveReceiptDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiveReceiptDetail record, @Param("example") ReceiveReceiptDetailExample example);

    int updateByExample(@Param("record") ReceiveReceiptDetail record, @Param("example") ReceiveReceiptDetailExample example);

    int updateByPrimaryKeySelective(ReceiveReceiptDetail record);

    int updateByPrimaryKey(ReceiveReceiptDetail record);
}