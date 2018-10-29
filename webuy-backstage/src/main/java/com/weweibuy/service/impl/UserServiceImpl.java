package com.weweibuy.service.impl;


import com.github.pagehelper.PageHelper;
import com.weweibuy.po.TbUser;
import com.weweibuy.po.TbUserExample;
import com.weweibuy.service.UserService;
import com.weweibuy.service.base.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
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


    public List<TbUser> getUsers(){
        PageHelper.startPage(1, 5);
        return this.selectByExample(null);
    }

}
