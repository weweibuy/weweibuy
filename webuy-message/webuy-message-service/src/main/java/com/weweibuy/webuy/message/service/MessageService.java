package com.weweibuy.webuy.message.service;

import com.weweibuy.webuy.message.common.model.dto.MessageDto;
import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.common.model.po.WebuyMessageExample;
import com.weweibuy.webuy.message.common.model.vo.MessageVo;
import com.weweibuy.webuy.message.service.base.BaseService;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @InterfaceName MessageService
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 16:10
 **/
public interface MessageService extends BaseService<WebuyMessage, WebuyMessageExample> {

    void sendMessage(Long id, String correlationId);

    MessageDto preSaveMessage(MessageVo message);

    void confirmMessage(@NotBlank String correlationId);

    WebuyMessage selectByDeliverCorrelationId(Long id, String correlationId);

    List<WebuyMessage> selectPageListWhereNotConfim(Integer page, Integer row);

    List<WebuyMessage> selectPageListWhereIsDead(Integer page, Integer row);

    void reSendDeadMessage(Long id, String correlationId);

}
