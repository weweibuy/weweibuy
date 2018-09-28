package com.weiwei.service;


import com.weiwei.po.TbUser;
import com.weiwei.po.TbUserExample;

import java.util.List;

/**
 * @InterfaceName UserService
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/23 16:52
 **/
public interface UserService extends BaseService<TbUser, TbUserExample> {

    List<TbUser> getUsers();
}
