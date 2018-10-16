package com.weweibuy.service;

import com.weweibuy.po.WeweibuyMessage;
import com.weweibuy.po.WeweibuyMessageExample;

/**
 * @InterfaceName MessageService
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 16:10
 **/
public interface MessageService extends BaseService<WeweibuyMessage, WeweibuyMessageExample> {
    void sendMessage(WeweibuyMessage message);
}
