package com.weweibuy.webuy.message.mapper;

import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.common.model.po.WebuyMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebuyMessageMapper {
    long countByExample(WebuyMessageExample example);

    int deleteByExample(WebuyMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WebuyMessage record);

    int insertSelective(WebuyMessage record);

    List<WebuyMessage> selectByExample(WebuyMessageExample example);

    WebuyMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WebuyMessage record, @Param("example") WebuyMessageExample example);

    int updateByExample(@Param("record") WebuyMessage record, @Param("example") WebuyMessageExample example);

    int updateByPrimaryKeySelective(WebuyMessage record);

    int updateByPrimaryKey(WebuyMessage record);
}