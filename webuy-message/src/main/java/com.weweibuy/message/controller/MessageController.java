package com.weweibuy.message.controller;

import com.weweibuy.common.dto.CommonJsonResponse;
import com.weweibuy.message.model.po.WeweibuyMessage;
import com.weweibuy.message.service.MessageService;
import com.weweibuy.common.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * 消息服务接口
 * @ClassName MessageController
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 13:19
 **/
@RestController
@RequestMapping("")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 预存储消息，保存消息，消息状态为待确认
     * @param message
     * @param result
     * @return
     */
    @PostMapping("/message/save")
    public CommonJsonResponse saveMessage(@RequestBody @Validated WeweibuyMessage message, BindingResult result){
        if(result.getErrorCount() > 0){
            return null;
        }
        message.setDeliverTag(IDUtil.getRandomMessage());
        messageService.insertSelective(message);
            return null;

    }


    /**
     * 上游业务处理成功，发送消息到broker接口
     * @return
     */
    @PutMapping("/message/sendMessage")
    public CommonJsonResponse sendMessage(@RequestBody WeweibuyMessage message){
        messageService.sendMessage(message);
        return null;
    }

    /**
     * 下游业务手动确认消息已经消费
     * @param deliverTag
     * @return
     */
    @DeleteMapping("/message/confirmMessage")
    public CommonJsonResponse confirmMessage(@Validated @NotBlank String deliverTag){
        return null;
    }

    /**
     * 根据消息id获取消息
     * @param id
     * @return
     */
    @GetMapping("/message/{id}")
    public CommonJsonResponse getMessageById(@PathVariable Long id){
        return null;
    }

    /**
     * 根据deliverTag获取消息
     * @param deliverTag
     * @return
     */
    @GetMapping("/message/deliverTag/{deliverTag}")
    public CommonJsonResponse getMessageByDeliverTag(@PathVariable String deliverTag) {
        return null;
    }

    /**
     * 分页获取消息
     * @return
     */
    @GetMapping("/messages")
    public CommonJsonResponse getMessages(){
        return null;
    }

    /**
     * 分页获取认定为死亡的消息（重发次数达到一定的值）
     * @return
     */
    @GetMapping("/messages/dead")
    public CommonJsonResponse getDeadMessage(){
        return null;
    }

    /**
     * 重发死亡的消息
     * @return
     */
    @PostMapping("/message/dead/send")
    public CommonJsonResponse reSendDeadMessage(){
        return null;
    }


}
