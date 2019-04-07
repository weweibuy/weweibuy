package com.weweibuy.webuy.message.controller;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.message.common.model.dto.MessageDto;
import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.common.model.vo.MessageVo;
import com.weweibuy.webuy.message.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Api(value = "消息接口", description = "消息接口")
@RestController
@RequestMapping(value = "/message", produces = "application/json;charset=utf-8")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 预存储消息，保存消息，消息状态为待确认
     * @param message
     * @param result
     * @return
     */
    @PostMapping("/pre-save")
    @ApiOperation(value = "预存储消息", notes = "预存储消息，保存消息，消息状态为待确认")
    public CommonJsonResponse<MessageDto> saveMessage(@RequestBody @Validated MessageVo message, BindingResult result){

            return null;
    }


    /**
     * 上游业务处理成功，发送消息到broker接口
     * @return
     */
    @PutMapping("/sendMessage")
    public CommonJsonResponse<MessageDto> sendMessage(@RequestBody WebuyMessage message){
        messageService.sendMessage(message);
        return null;
    }

    /**
     * 下游业务手动确认消息已经消费
     * @param deliverTag
     * @return
     */
    @DeleteMapping("/confirmMessage")
    public CommonJsonResponse<MessageDto> confirmMessage(@Validated @NotBlank String deliverTag){
        return null;
    }

    /**
     * 根据消息id获取消息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CommonJsonResponse<MessageDto> getMessageById(@PathVariable Long id){
        return null;
    }

    /**
     * 根据deliverTag获取消息
     * @param deliverTag
     * @return
     */
    @GetMapping("/deliverTag/{deliverTag}")
    public CommonJsonResponse<MessageDto> getMessageByDeliverTag(@PathVariable String deliverTag) {
        return null;
    }

    /**
     * 分页获取消息
     * @return
     */
    @GetMapping("/messages")
    public CommonJsonResponse<MessageDto> getMessages(){
        return null;
    }

    /**
     * 分页获取认定为死亡的消息（重发次数达到一定的值）
     * @return
     */
    @GetMapping("/dead")
    public CommonJsonResponse<MessageDto> getDeadMessage(){
        return null;
    }

    /**
     * 重发死亡的消息
     * @return
     */
    @PostMapping("/dead/send")
    public CommonJsonResponse<MessageDto> reSendDeadMessage(){
        return null;
    }


}
