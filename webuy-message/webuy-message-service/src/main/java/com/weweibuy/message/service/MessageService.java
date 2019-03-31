package com.weweibuy.message.service;

import com.weweibuy.message.common.model.po.WebuyMessage;
import com.weweibuy.message.common.model.po.WebuyMessageExample;
import com.weweibuy.message.service.base.BaseService;

/**
 * @InterfaceName MessageService
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 16:10
 **/
public interface MessageService extends BaseService<WebuyMessage, WebuyMessageExample> {
    void sendMessage(WebuyMessage message);
}
