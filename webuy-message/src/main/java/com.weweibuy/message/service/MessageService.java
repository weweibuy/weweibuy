package com.weweibuy.message.service;

import com.weweibuy.message.model.po.WeweibuyMessage;
import com.weweibuy.message.model.po.WeweibuyMessageExample;
import com.weweibuy.message.service.base.BaseService;

/**
 * @InterfaceName MessageService
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 16:10
 **/
public interface MessageService extends BaseService<WeweibuyMessage, WeweibuyMessageExample> {
    void sendMessage(WeweibuyMessage message);
}
