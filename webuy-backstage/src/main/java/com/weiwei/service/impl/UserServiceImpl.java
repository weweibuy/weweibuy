package com.weiwei.service.impl;


import com.github.pagehelper.PageHelper;
import com.weiwei.po.TbUser;
import com.weiwei.po.TbUserExample;
import com.weiwei.service.UserService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/23 16:54
 **/
@Service
@CommonsLog
public class UserServiceImpl extends BaseServiceImpl<TbUser, TbUserExample> implements UserService {


    public List<TbUser> getUsers(){
        log.error("测试日志");
        PageHelper.startPage(1, 5);
        return this.selectByExample(null);
    }

}
