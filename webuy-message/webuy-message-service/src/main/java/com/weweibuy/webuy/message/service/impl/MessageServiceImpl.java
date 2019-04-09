package com.weweibuy.webuy.message.service.impl;

import com.baidu.fsg.uid.UidGenerator;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.weweibuy.webuy.message.amqp.MessageSender;
import com.weweibuy.webuy.message.common.model.dto.MessageDto;
import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.common.model.po.WebuyMessageExample;
import com.weweibuy.webuy.message.common.model.vo.ConfirmMessageVo;
import com.weweibuy.webuy.message.common.model.vo.PreSaveMessageVo;
import com.weweibuy.webuy.message.exception.BizException;
import com.weweibuy.webuy.message.service.MessageService;
import com.weweibuy.webuy.message.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 消息服务类
 * @ClassName MessageServiceImpl
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 16:10
 **/
@Service
public class MessageServiceImpl extends BaseServiceImpl<WebuyMessage, WebuyMessageExample> implements MessageService {

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private UidGenerator uidGenerator;

    /**
     * 发送消息到 broker, 跟改消息为已发送
     * @param confirmMessageVo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public WebuyMessage sendMessage(ConfirmMessageVo confirmMessageVo) {
        WebuyMessageExample example = new WebuyMessageExample();
        WebuyMessageExample.Criteria criteria = example.createCriteria()
                .andIdEqualTo(confirmMessageVo.getId())
                .andMessageCorrelationIdEqualTo(confirmMessageVo.getMessageCorrelationId());
        List<WebuyMessage> messageList = selectByExample(example);
        if(messageList.size() == 1) {
            WebuyMessage message = messageList.get(0);
            WebuyMessage message1 = new WebuyMessage();
            message1.setMessageSendTime((byte)(message.getMessageSendTime() + 1));
            example.clear();
            example.createCriteria()
                    .andIdEqualTo(confirmMessageVo.getId())
                    .andMessageCorrelationIdEqualTo(confirmMessageVo.getMessageCorrelationId());
            updateByExampleSelective(message, example);

            // 发送消息
            messageSender.send(message);
            message.setMessageSendTime((byte)1);
            return message;
        }
        throw new BizException("无法获取到消息");
    }

    /**
     *
     * @param message
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public MessageDto preSaveMessage(PreSaveMessageVo message) {
        WebuyMessage webuyMessage = message.conventToPo();
        webuyMessage.setId(uidGenerator.getUID());
        insertSelective(webuyMessage);
        return MessageDto.builder()
                .id(webuyMessage.getId())
                .isDead((byte) 0)
                .messageCorrelationId(message.getMessageCorrelationId())
                .messageStatus((byte)0)
                .messageSendTime((byte) 0)
                .build();
    }

    @Override
    public void confirmMessage(ConfirmMessageVo confirmMessageVo) {
        WebuyMessageExample example = new WebuyMessageExample();
        example.createCriteria().andMessageCorrelationIdEqualTo(confirmMessageVo.getMessageCorrelationId());
        deleteByExample(example);
    }

    @Override
    public WebuyMessage selectByDeliverCorrelationId(Long id, String correlationId) {
        WebuyMessageExample example = new WebuyMessageExample();
        example.createCriteria()
                .andMessageCorrelationIdEqualTo(correlationId)
                .andIdEqualTo(id);
        List<WebuyMessage> messageList = selectByExample(example);
        return messageList.size() == 1 ? messageList.get(0) : null;
    }

    @Override
    public List<WebuyMessage> selectPageListWhereNotConfim(Integer page, Integer row) {
        Page<Object> page1 = PageHelper.startPage(page, row);
        WebuyMessageExample example = new WebuyMessageExample();
        example.createCriteria().andIsDeadEqualTo((byte) 0);
        return (List<WebuyMessage>) selectByExample(example);
    }

    @Override
    public List<WebuyMessage> selectPageListWhereIsDead(Integer page, Integer row) {
        Page<Object> page1 = PageHelper.startPage(page, row);
        WebuyMessageExample example = new WebuyMessageExample();
        example.createCriteria().andIsDeadEqualTo((byte) 1);
        return (List<WebuyMessage>) selectByExample(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void reSendDeadMessage(ConfirmMessageVo confirmMessageVo) {
        WebuyMessageExample example = new WebuyMessageExample();
        example.createCriteria()
                .andMessageCorrelationIdEqualTo(confirmMessageVo.getMessageCorrelationId())
                .andIdEqualTo(confirmMessageVo.getId());
        List<WebuyMessage> messageList = selectByExample(example);
        if(messageList.size() == 1){
            WebuyMessage message = messageList.get(0);
            // 重新发送
            messageSender.send(message);
        }
    }

    @Override
    public void deleteBizFailMessage(ConfirmMessageVo confirmMessageVo) {
        WebuyMessageExample example = new WebuyMessageExample();
        example.createCriteria()
                .andMessageCorrelationIdEqualTo(confirmMessageVo.getMessageCorrelationId());
        deleteByExample(example);
    }

    @Override
    public WebuyMessage reSendMessage(ConfirmMessageVo confirmMessageVo) {
        WebuyMessageExample example = new WebuyMessageExample();
        WebuyMessageExample.Criteria criteria = example.createCriteria()
                .andIdEqualTo(confirmMessageVo.getId())
                .andMessageCorrelationIdEqualTo(confirmMessageVo.getMessageCorrelationId());
        List<WebuyMessage> messageList = selectByExample(example);
        if(messageList.size() == 1) {
            WebuyMessage message = messageList.get(0);
            if(message.getMessageSendTime() == 3){
                deadMessages(confirmMessageVo.getMessageCorrelationId());
                message.setIsDead((byte) 1);
                return message;
            }else {
                // 重发
                messageSender.send(message);
                message.setMessageSendTime((byte)(message.getMessageSendTime() + 1));
                return message;
            }
        }
        throw new BizException("无法获取到消息");
    }


    public void deadMessages(String messageCorrelationId){
        WebuyMessageExample example = new WebuyMessageExample();
        WebuyMessage message = new WebuyMessage();
        message.setIsDead((byte)1);
        example.createCriteria()
                .andMessageCorrelationIdEqualTo(messageCorrelationId);
        updateByExampleSelective(message, example);
    }
}
