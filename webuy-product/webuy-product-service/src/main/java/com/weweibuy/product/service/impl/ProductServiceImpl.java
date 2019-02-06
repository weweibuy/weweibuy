package com.weweibuy.product.service.impl;

import com.weweibuy.dto.CommonJsonResponse;
import com.weweibuy.product.common.model.form.WebuyItemForm;
import com.weweibuy.product.common.model.po.WebuyItem;
import com.weweibuy.product.common.model.po.WebuyItemExample;
import com.weweibuy.product.mapper.WebuyItemMapper;
import com.weweibuy.product.service.ProductService;
import com.weweibuy.product.service.impl.base.BaseCrudServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description
 * @Author durenhao
 * @Date 2019/2/6 19:31
 **/
@Slf4j
@Service
public class ProductServiceImpl extends BaseCrudServiceImpl<WebuyItem, WebuyItemExample> implements ProductService {

    @Autowired
    private WebuyItemMapper itemMapper;

    @Override
    public WebuyItem getItemById(Long id) {
        WebuyItemExample example = new WebuyItemExample();
        byte b = 0;
        example.createCriteria().andItemIdEqualTo(id).andIsDeleteNotEqualTo(b);
        List<WebuyItem> webuyItems = itemMapper.selectByExample(example);
        if(webuyItems.size() > 0){
            return webuyItems.get(0);
        }
        return null;
    }

    @Override
    public CommonJsonResponse addItem(WebuyItemForm itemForm) {
        WebuyItem webuyItem = new WebuyItem();
        BeanUtils.copyProperties(itemForm, webuyItem);
        Long itemId = webuyItem.getItemId();
        WebuyItemExample example = new WebuyItemExample();
        WebuyItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<WebuyItem> webuyItems = itemMapper.selectByExample(example);
        // 先进行幂等性判断
        if(webuyItems != null && webuyItems.size() != 0){
            return CommonJsonResponse.success();
        }
        example.clear();
        itemMapper.insertSelective(webuyItem);
        return CommonJsonResponse.success();
    }

    @Override
    public CommonJsonResponse delItemById(Long id) {
        WebuyItem webuyItem = new WebuyItem();
        webuyItem.setId(id);
        byte b = 1;
        webuyItem.setIsDelete(b);
        itemMapper.updateByPrimaryKeySelective(webuyItem);
        return CommonJsonResponse.success();
    }
}
