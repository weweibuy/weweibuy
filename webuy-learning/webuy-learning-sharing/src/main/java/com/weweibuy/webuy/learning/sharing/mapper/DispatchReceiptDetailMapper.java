package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.DispatchReceiptDetail;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchReceiptDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DispatchReceiptDetailMapper {
    long countByExample(DispatchReceiptDetailExample example);

    int deleteByExample(DispatchReceiptDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DispatchReceiptDetail record);

    int insertSelective(DispatchReceiptDetail record);

    List<DispatchReceiptDetail> selectByExample(DispatchReceiptDetailExample example);

    DispatchReceiptDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DispatchReceiptDetail record, @Param("example") DispatchReceiptDetailExample example);

    int updateByExample(@Param("record") DispatchReceiptDetail record, @Param("example") DispatchReceiptDetailExample example);

    int updateByPrimaryKeySelective(DispatchReceiptDetail record);

    int updateByPrimaryKey(DispatchReceiptDetail record);
}