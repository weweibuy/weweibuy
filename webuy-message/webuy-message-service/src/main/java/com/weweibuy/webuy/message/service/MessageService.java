package com.weweibuy.webuy.message.service;

import com.weweibuy.webuy.message.common.model.dto.MessageDto;
import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.common.model.po.WebuyMessageExample;
import com.weweibuy.webuy.message.common.model.vo.ConfirmMessageVo;
import com.weweibuy.webuy.message.common.model.vo.PreSaveMessageVo;
import com.weweibuy.webuy.message.service.base.BaseService;

import java.util.List;

/**
 * @InterfaceName MessageService
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 16:10
 **/
public interface MessageService extends BaseService<WebuyMessage, WebuyMessageExample> {

    WebuyMessage sendMessage(ConfirmMessageVo confirmMessageVo);

    MessageDto preSaveMessage(PreSaveMessageVo message);

    void confirmMessage(ConfirmMessageVo confirmMessageVo);

    WebuyMessage selectByDeliverCorrelationId(Long id, String correlationId);

    List<WebuyMessage> selectPageListWhereNotConfim(Integer page, Integer row);

    List<WebuyMessage> selectPageListWhereIsDead(Integer page, Integer row);

    void reSendDeadMessage(ConfirmMessageVo confirmMessageVo);

    void deleteBizFailMessage(ConfirmMessageVo confirmMessageVo);

    WebuyMessage reSendMessage(ConfirmMessageVo confirmMessageVo);

    /**
     * 将消息变为死亡
     * @param messageCorrelationId
     */
    void deadMessages(String messageCorrelationId);

}
