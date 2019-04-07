package com.weweibuy.webuy.message.service;

import com.weweibuy.webuy.message.common.model.dto.MessageDto;
import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.common.model.po.WebuyMessageExample;
import com.weweibuy.webuy.message.common.model.vo.MessageVo;
import com.weweibuy.webuy.message.service.base.BaseService;

/**
 * @InterfaceName MessageService
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 16:10
 **/
public interface MessageService extends BaseService<WebuyMessage, WebuyMessageExample> {
    void sendMessage(WebuyMessage message);

    MessageDto preSaveMessage(MessageVo message);
}
