package com.weweibuy.webuy.order.mapper;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T, V>  {

        int countByExample(V v);

        int deleteByExample(V v);

        int deleteByPrimaryKey(Serializable id);

        int insert(T t);

        int insertSelective(T t);

        List<T> selectByExample(V v);

        T selectByPrimaryKey(Serializable id);

        int updateByExampleSelective(@Param("record") T t, @Param("example") V v);

        int updateByExample(@Param("record") T t, @Param("example") V v);

        int updateByPrimaryKeySelective(T t);

        int updateByPrimaryKey(T t);

}
