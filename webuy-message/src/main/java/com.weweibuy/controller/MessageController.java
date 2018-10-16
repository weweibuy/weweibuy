package com.weweibuy.controller;

import com.weweibuy.dto.WebResult;
import com.weweibuy.po.WeweibuyMessage;
import com.weweibuy.service.MessageService;
import com.weweibuy.utils.IDUtil;
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
    public WebResult saveMessage(@RequestBody @Validated WeweibuyMessage message, BindingResult result){
        if(result.getErrorCount() > 0){
            return WebResult.paramWrong();
        }
        message.setDeliverTag(IDUtil.getRandomMessage());
        messageService.insertSelective(message);
        return WebResult.success(message);
    }


    /**
     * 上游业务处理成功，发送消息到broker接口
     * @return
     */
    @PutMapping("/message/sendMessage")
    public WebResult sendMessage(@RequestBody WeweibuyMessage message){
        messageService.sendMessage(message);
        return WebResult.success();
    }

    /**
     * 下游业务手动确认消息已经消费
     * @param deliverTag
     * @return
     */
    @DeleteMapping("/message/confirmMessage")
    public WebResult confirmMessage(@Validated @NotBlank String deliverTag){
        return null;
    }

    /**
     * 根据消息id获取消息
     * @param id
     * @return
     */
    @GetMapping("/message/{id}")
    public WebResult getMessageById(@PathVariable Long id){
        return null;
    }

    /**
     * 根据deliverTag获取消息
     * @param deliverTag
     * @return
     */
    @GetMapping("/message/deliverTag/{deliverTag}")
    public WebResult getMessageByDeliverTag(@PathVariable String deliverTag) {
        return null;
    }

    /**
     * 分页获取消息
     * @return
     */
    @GetMapping("/messages")
    public WebResult getMessages(){
        return null;
    }

    /**
     * 分页获取认定为死亡的消息（重发次数达到一定的值）
     * @return
     */
    @GetMapping("/messages/dead")
    public WebResult getDeadMessage(){
        return null;
    }

    /**
     * 重发死亡的消息
     * @return
     */
    @PostMapping("/message/dead/send")
    public WebResult reSendDeadMessage(){
        return null;
    }


}
