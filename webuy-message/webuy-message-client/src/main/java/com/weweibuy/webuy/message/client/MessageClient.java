package com.weweibuy.webuy.message.client;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.common.eum.CommonWebMsg;
import com.weweibuy.webuy.message.client.fallback.MessageClientFallBack;
import com.weweibuy.webuy.message.common.model.dto.MessageDto;
import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.common.model.vo.ConfirmMessageVo;
import com.weweibuy.webuy.message.common.model.vo.PreSaveMessageVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName MessageClient
 * @Description
 * @Author durenhao
 * @Date 2019/2/31 22:35
 **/
@FeignClient(value = "webuy-message", fallbackFactory = MessageClientFallBack.class)
public interface MessageClient {


    @RequestMapping(value = "/pre-save", method = RequestMethod.POST)
    public CommonJsonResponse<MessageDto> saveMessage(@RequestBody PreSaveMessageVo message, BindingResult result);


    /**
     * 上游业务处理成功，发送消息到broker接口
     *
     * @param confirmMessageVo
     * @return
     */
    @RequestMapping(value = "/send-message", method = RequestMethod.PUT)
    public CommonJsonResponse<MessageDto> sendMessage(@RequestBody ConfirmMessageVo confirmMessageVo);


    /**
     * 重新发送消息
     *
     * @param confirmMessageVo
     * @return
     */
    @RequestMapping(value = "/re-send-message", method = RequestMethod.PUT)
    public CommonJsonResponse<MessageDto> reSendMessage(@RequestBody ConfirmMessageVo confirmMessageVo);


    /**
     * 上游业务失败,业务预存储的消息
     *
     * @param confirmMessageVo
     * @param result
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public CommonJsonResponse deleteBizFailMessage(@RequestBody ConfirmMessageVo confirmMessageVo);


    /**
     * 下游业务手动确认消息已经消费
     *
     * @param confirmMessageVo
     * @return
     */
    @RequestMapping(value = "/confirm-message", method = RequestMethod.DELETE)
    public CommonJsonResponse<MessageDto> confirmMessage(@RequestBody ConfirmMessageVo confirmMessageVo);


    /**
     * 根据获取消息
     *
     * @param id
     * @param correlationId
     * @return
     */
    @RequestMapping(value = "/{id}/{correlationId}", method = RequestMethod.GET)
    public CommonJsonResponse<MessageDto> getMessageByDeliverTag(@PathVariable Long id, @PathVariable String correlationId);


    /**
     * 分页获取未确认消息
     *
     * @param page
     * @param row
     * @return
     */
    @GetMapping("/page/{page}/row/{row}")
    @RequestMapping(value = "/page/{page}/row/{row}", method = RequestMethod.GET)
    public CommonJsonResponse<List<MessageDto>> getMessages(@PathVariable Integer page, @PathVariable Integer row);

    /**
     * 分页获取认定为死亡的消息（重发次数达到一定的值）
     *
     * @return
     */
    @RequestMapping(value = "/dead/page/{page}/row/{row}", method = RequestMethod.GET)
    public CommonJsonResponse<MessageDto> getDeadMessage(@PathVariable Integer page, @PathVariable Integer row);

    /**
     * 重发死亡的消息
     *
     * @return
     */
    @PostMapping("/dead/send")
    @RequestMapping(value = "/dead/send", method = RequestMethod.POST)
    public CommonJsonResponse reSendDeadMessage(@RequestBody ConfirmMessageVo confirmMessageVo);

}
