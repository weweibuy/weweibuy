package com.weweibuy.webuy.backstage.service.impl;


import com.github.pagehelper.PageHelper;
import com.weweibuy.webuy.backstage.po.TbUser;
import com.weweibuy.webuy.backstage.po.TbUserExample;
import com.weweibuy.webuy.backstage.service.UserService;
import com.weweibuy.webuy.backstage.service.base.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/23 16:54
 **/
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<TbUser, TbUserExample> implements UserService {

    @Retryable()
    @Cacheable
    public List<TbUser> getUsers(){
        PageHelper.startPage(1, 5);
        return this.selectByExample(null);
    }

}
