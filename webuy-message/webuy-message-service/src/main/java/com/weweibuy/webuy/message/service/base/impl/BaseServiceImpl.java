package com.weweibuy.webuy.message.service.base.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.mapper.base.BaseMapper;
import com.weweibuy.webuy.message.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<T, V> implements BaseService<T, V> {

    @Autowired
    private BaseMapper<T,V> baseMapper;

    @Override
    public int countByExample(V v) {
        return baseMapper.countByExample(v);
    }

    @Override
    public int deleteByExample(V v) {
        return baseMapper.deleteByExample(v);
    }

    @Override
    public int deleteByPrimaryKey(Serializable id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T t) {
        return baseMapper.insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return baseMapper.insertSelective(t);
    }

    @Override
    public List<T> selectByExample(V v) {
        return baseMapper.selectByExample(v);
    }

    @Override
    public T selectByPrimaryKey(Serializable id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(T t, V v) {
        return baseMapper.updateByExampleSelective(t, v);
    }

    @Override
    public int updateByExample(T t, V v) {
        return baseMapper.updateByExample(t, v);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return baseMapper.updateByPrimaryKey(t);
    }

    @Override
    public List<WebuyMessage> selectPageList(Integer page, Integer rows) {
        Page<Object> page1 = PageHelper.startPage(page, rows);
        return (List<WebuyMessage>) selectByExample(null);
    }




}
