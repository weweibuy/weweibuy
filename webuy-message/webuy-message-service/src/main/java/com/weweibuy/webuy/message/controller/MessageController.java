package com.weweibuy.webuy.message.controller;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.common.eum.CommonWebMsg;
import com.weweibuy.webuy.message.common.model.dto.MessageDto;
import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.common.model.vo.ConfirmMessageVo;
import com.weweibuy.webuy.message.common.model.vo.PreSaveMessageVo;
import com.weweibuy.webuy.message.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 消息服务接口
 *
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
     *
     * @param message
     * @param result
     * @return
     */
    @PostMapping("/pre-save")
    @ApiOperation(value = "预存储消息", notes = "预存储消息，保存消息，消息状态为待确认")
    public CommonJsonResponse<MessageDto> saveMessage(@RequestBody @Validated PreSaveMessageVo message, BindingResult result) {
        if (result.hasErrors()) {
            return CommonJsonResponse.fail(CommonWebMsg.PARAM_WRONG).appendMsg(result);
        }
        return CommonJsonResponse.success(messageService.preSaveMessage(message));
    }


    /**
     * 上游业务处理成功，发送消息到broker接口
     *
     * @param confirmMessageVo
     * @param result
     * @return
     */
    @PutMapping("/send-message")
    @ApiOperation(value = "发送消息", notes = "游业务处理成功，发送消息到broker接口")
    public CommonJsonResponse<MessageDto> sendMessage(@RequestBody @Validated ConfirmMessageVo confirmMessageVo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonJsonResponse.fail(CommonWebMsg.PARAM_WRONG).appendMsg(result);
        }
        WebuyMessage message = messageService.sendMessage(confirmMessageVo);
        return CommonJsonResponse.success(MessageDto.conventPoToDto(message));
    }

    /**
     * 重新发送消息
     *
     * @param confirmMessageVo
     * @param result
     * @return
     */
    @PutMapping("/re-send-message")
    @ApiOperation(value = "重新发送消息", notes = "收到调度指令,重发消息")
    public CommonJsonResponse<MessageDto> reSendMessage(@RequestBody @Validated ConfirmMessageVo confirmMessageVo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonJsonResponse.fail(CommonWebMsg.PARAM_WRONG).appendMsg(result);
        }
        WebuyMessage message = messageService.reSendMessage(confirmMessageVo);
        return CommonJsonResponse.success(MessageDto.conventPoToDto(message));
    }


    /**
     * 上游业务失败,业务预存储的消息
     *
     * @param confirmMessageVo
     * @param result
     * @return
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "上游业务删除消息", notes = "上游业务失败,业务预存储的消息")
    public CommonJsonResponse deleteBizFailMessage(@RequestBody @Validated ConfirmMessageVo confirmMessageVo,
                                                   BindingResult result) {
        if (result.hasErrors()) {
            return CommonJsonResponse.fail(CommonWebMsg.PARAM_WRONG).appendMsg(result);
        }
        messageService.deleteBizFailMessage(confirmMessageVo);
        return CommonJsonResponse.success(confirmMessageVo);
    }

    /**
     * 下游业务手动确认消息已经消费
     *
     * @param confirmMessageVo
     * @return
     */
    @DeleteMapping("/confirm-message")
    @ApiOperation(value = "确认并删除消息", notes = "下游业务手动确认消息已经消费")
    public CommonJsonResponse<MessageDto> confirmMessage(@RequestBody @Validated ConfirmMessageVo confirmMessageVo,
                                                               BindingResult result) {
        if (result.hasErrors()) {
            return CommonJsonResponse.fail(CommonWebMsg.PARAM_WRONG).appendMsg(result);
        }
        messageService.confirmMessage(confirmMessageVo);
        return CommonJsonResponse.success(confirmMessageVo);
    }


    /**
     * 根据获取消息
     *
     * @param id
     * @param correlationId
     * @return
     */
    @GetMapping("/{id}/{correlationId}")
    @ApiOperation(value = "根据消息correlationId获取消息", notes = "根据消息correlationId获取消息")
    public CommonJsonResponse<MessageDto> getMessageByDeliverTag(@ApiParam(name = "消息id") @PathVariable Long id,
                                                                 @ApiParam(name = "消息correlationId") @PathVariable String correlationId) {
        WebuyMessage message = messageService.selectByDeliverCorrelationId(id, correlationId);
        return message != null ? CommonJsonResponse.success(MessageDto.conventPoToDto(message)) :
                CommonJsonResponse.fail(CommonWebMsg.NO_RECORD);
    }


    /**
     * 分页获取未确认消息
     *
     * @param page
     * @param row
     * @return
     */
    @GetMapping("/page/{page}/row/{row}")
    @ApiOperation(value = "分页获取未确认消息", notes = "分页获取未确认消息")
    public CommonJsonResponse<List<MessageDto>> getMessages(@ApiParam(name = "起始页数") @PathVariable Integer page,
                                                            @ApiParam(name = "每页条数") @PathVariable Integer row) {
        return CommonJsonResponse.success(MessageDto.conventListPoToDto(messageService.selectPageListWhereNotConfim(page, row)));
    }

    /**
     * 分页获取认定为死亡的消息（重发次数达到一定的值）
     *
     * @return
     */
    @GetMapping("/dead/page/{page}/row/{row}")
    @ApiOperation(value = "分页获取认定为死亡的消息", notes = "分页获取认定为死亡的消息")
    public CommonJsonResponse<MessageDto> getDeadMessage(@ApiParam(name = "起始页数") @PathVariable Integer page,
                                                         @ApiParam(name = "每页条数") @PathVariable Integer row) {
        return CommonJsonResponse.success(MessageDto.conventListPoToDto(messageService.selectPageListWhereIsDead(page, row)));
    }

    /**
     * 重发死亡的消息
     *
     * @return
     */
    @PostMapping("/dead/send")
    @ApiOperation(value = "重发死亡的消息", notes = "重发死亡的消息")
    public CommonJsonResponse reSendDeadMessage(@RequestBody @Validated ConfirmMessageVo confirmMessageVo,
                                                BindingResult result) {
        if (result.hasErrors()) {
            return CommonJsonResponse.fail(CommonWebMsg.PARAM_WRONG).appendMsg(result);
        }
        messageService.reSendDeadMessage(confirmMessageVo);
        return CommonJsonResponse.success();
    }


}
