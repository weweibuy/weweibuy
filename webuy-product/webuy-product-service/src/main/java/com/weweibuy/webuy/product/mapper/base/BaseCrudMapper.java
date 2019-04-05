package com.weweibuy.webuy.product.mapper.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BaseCrudMapper
 * @Description
 * @Author durenhao
 * @Date 2018/11/29 21:44
 **/
public interface BaseCrudMapper<T, V> {

    long countByExample(T t);

    int deleteByExample(V v);

    int deleteByPrimaryKey(Long id);

    int insert(T t);

    int insertSelective(V v);

    List<T> selectByExample(V v);

    T selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") T t, @Param("example") V v);

    int updateByExample(@Param("record") T t, @Param("example") V v);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

}
