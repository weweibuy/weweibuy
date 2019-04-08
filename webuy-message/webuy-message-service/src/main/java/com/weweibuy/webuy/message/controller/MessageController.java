package com.weweibuy.webuy.message.controller;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.common.eum.CommonWebMsg;
import com.weweibuy.webuy.message.common.model.dto.MessageDto;
import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.common.model.vo.MessageVo;
import com.weweibuy.webuy.message.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    public CommonJsonResponse<MessageDto> saveMessage(@RequestBody @Validated MessageVo message, BindingResult result) {
        if (result.hasErrors()) {
            return CommonJsonResponse.fail(CommonWebMsg.PARAM_WRONG).appendMsg(result);
        }
        return CommonJsonResponse.success(messageService.preSaveMessage(message));
    }


    /**
     * 上游业务处理成功，发送消息到broker接口
     *
     * @return
     */
    @PutMapping("/sendMessage")
    @ApiOperation(value = "发送消息", notes = "游业务处理成功，发送消息到broker接口")
    public CommonJsonResponse sendMessage(@ApiParam(name = "消息id", required = true) @Validated @NotNull Long id,
                                          @ApiParam(name = "消息correlationId", required = true) @Validated @NotBlank String correlationId,
                                          BindingResult result) {
        if (result.hasErrors()) {
            return CommonJsonResponse.fail(CommonWebMsg.PARAM_WRONG);
        }
        messageService.sendMessage(id, correlationId);
        return CommonJsonResponse.success();
    }

    /**
     * 下游业务手动确认消息已经消费
     *
     * @param correlationId
     * @return
     */
    @DeleteMapping("/confirmMessage")
    @ApiOperation(value = "确认并删除消息", notes = "下游业务手动确认消息已经消费")
    public CommonJsonResponse<String> confirmMessage(@ApiParam(name = "消息correlationId", required = true) @Validated @NotBlank String correlationId) {
        messageService.confirmMessage(correlationId);
        return CommonJsonResponse.success(correlationId);
    }


    /**
     * 根据获取消息
     *
     * @param id
     * @param correlationId
     * @return
     */
    @GetMapping("/correlationId/{id}/{correlationId}")
    @ApiOperation(value = "根据消息correlationId获取消息", notes = "根据消息correlationId获取消息")
    public CommonJsonResponse<MessageDto> getMessageByDeliverTag(@ApiParam(name = "消息correlationId") @PathVariable Long id,
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
    @GetMapping("/messages/page/{page}/row/{row}")
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
    @PostMapping("/dead/send/{id}/{correlationId}")
    @ApiOperation(value = "重发死亡的消息", notes = "重发死亡的消息")
    public CommonJsonResponse reSendDeadMessage(@ApiParam(name = "消息Id") @PathVariable Long id,
                                                @ApiParam(name = "消息correlationId") @PathVariable String correlationId) {
        messageService.reSendDeadMessage(id, correlationId);
        return CommonJsonResponse.success();
    }


}
