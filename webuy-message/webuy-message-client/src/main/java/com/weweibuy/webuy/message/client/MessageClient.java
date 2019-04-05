package com.weweibuy.webuy.message.client;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.message.client.fallback.MessageClientFallBack;
import com.weweibuy.webuy.message.common.model.dto.MessageDto;
import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.common.model.vo.MessageVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName MessageClient
 * @Description
 * @Author durenhao
 * @Date 2019/3/31 22:35
 **/
@FeignClient(value = "webuy-message", fallbackFactory = MessageClientFallBack.class)
public interface MessageClient {


    /**
     * 预存储消息，保存消息，消息状态为待确认
     * @param message
     * @return
     */
    @RequestMapping(value = "/message/pre-save", method = RequestMethod.POST)
    CommonJsonResponse<MessageDto> saveMessage(@RequestBody @Validated MessageVo message);



    /**
     * 上游业务处理成功，发送消息到broker接口
     * @return
     */
    @RequestMapping(value = "/message/sendMessage", method = RequestMethod.PUT)
    public CommonJsonResponse<MessageDto> sendMessage(@RequestBody WebuyMessage message);

    /**
     * 下游业务手动确认消息已经消费
     * @param deliverTag
     * @return
     */
    @RequestMapping(value = "/message/confirmMessage", method = RequestMethod.DELETE)
    public CommonJsonResponse<MessageDto> confirmMessage(String deliverTag);

    /**
     * 根据消息id获取消息
     * @param id
     * @return
     */
    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    public CommonJsonResponse<MessageDto> getMessageById(@PathVariable Long id);

    /**
     * 根据deliverTag获取消息
     * @param deliverTag
     * @return
     */
    @RequestMapping(value = "/message/deliverTag/{deliverTag}", method = RequestMethod.GET)
    public CommonJsonResponse<MessageDto> getMessageByDeliverTag(@PathVariable String deliverTag);

    /**
     * 分页获取消息
     * @return
     */
    @RequestMapping(value = "/message/messages", method = RequestMethod.GET)
    public CommonJsonResponse<MessageDto> getMessages();

    /**
     * 分页获取认定为死亡的消息（重发次数达到一定的值）
     * @return
     */
    @RequestMapping(value = "/message/dead", method = RequestMethod.GET)
    public CommonJsonResponse<MessageDto> getDeadMessage();

    /**
     * 重发死亡的消息
     * @return
     */
    @RequestMapping(value = "/message/dead/send", method = RequestMethod.PUT)
    public CommonJsonResponse<MessageDto> reSendDeadMessage();


}
