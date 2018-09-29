package com.weweibuy.service;


import com.weweibuy.po.TbUser;
import com.weweibuy.po.TbUserExample;

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
