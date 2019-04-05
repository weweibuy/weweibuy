package com.weweibuy.webuy.backstage.service;


import com.weweibuy.webuy.backstage.po.TbUser;
import com.weweibuy.webuy.backstage.po.TbUserExample;
import com.weweibuy.webuy.backstage.service.base.BaseService;

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
