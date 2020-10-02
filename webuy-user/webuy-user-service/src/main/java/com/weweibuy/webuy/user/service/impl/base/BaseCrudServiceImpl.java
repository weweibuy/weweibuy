package com.weweibuy.webuy.user.service.impl.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.weweibuy.framework.common.core.model.dto.CommonPageResult;
import com.weweibuy.webuy.user.mapper.base.BaseCrudMapper;
import com.weweibuy.webuy.user.service.base.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BaseCrudServiceImpl
 * @Description
 * @Author durenhao
 * @Date 2018/11/29 21:53
 **/
@Service
public class BaseCrudServiceImpl<T, V> implements BaseCrudService<T, V> {

    @Autowired
    private BaseCrudMapper<T,V> baseCrudMapper;

    @Override
    public long countByExample(T t) {
        return baseCrudMapper.countByExample( t);
    }

    @Override
    public int deleteByExample(V v) {
        return baseCrudMapper.deleteByExample(v);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return baseCrudMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T t) {
        return baseCrudMapper.insert(t);
    }

    @Override
    public int insertSelective(V v) {
        return baseCrudMapper.insertSelective(v);
    }

    @Override
    public List<T> selectByExample(V v) {
        return baseCrudMapper.selectByExample(v);
    }

    @Override
    public T selectByPrimaryKey(Long id) {
        return baseCrudMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(T t, V v) {
        return baseCrudMapper.updateByExampleSelective(t, v);
    }

    @Override
    public int updateByExample(T t, V v) {
        return baseCrudMapper.updateByExample(t, v);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return baseCrudMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return baseCrudMapper.updateByPrimaryKey(t);
    }

    @Override
    public CommonPageResult selectPageList(Integer page, Integer rows) {
        Page<Object> pages = PageHelper.startPage(page, rows);
        List<T> list = selectByExample(null);
        CommonPageResult pageBean = new CommonPageResult();
        pageBean.setTotal(pages.getTotal());
        pageBean.setList(list);
        return pageBean;
    }
}
