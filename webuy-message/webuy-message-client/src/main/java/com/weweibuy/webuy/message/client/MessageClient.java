package com.weweibuy.webuy.message.client;

import com.weweibuy.webuy.common.model.dto.CommonDataJsonResponse;
import com.weweibuy.webuy.message.client.fallback.MessageClientFallBack;
import com.weweibuy.webuy.message.common.model.dto.MessageDto;
import com.weweibuy.webuy.message.common.model.vo.ConfirmMessageVo;
import com.weweibuy.webuy.message.common.model.vo.PreSaveMessageVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public CommonDataJsonResponse<MessageDto> saveMessage(@RequestBody PreSaveMessageVo message, BindingResult result);


    /**
     * 上游业务处理成功，发送消息到broker接口
     *
     * @param confirmMessageVo
     * @return
     */
    @RequestMapping(value = "/send-message", method = RequestMethod.PUT)
    public CommonDataJsonResponse<MessageDto> sendMessage(@RequestBody ConfirmMessageVo confirmMessageVo);


    /**
     * 重新发送消息
     *
     * @param confirmMessageVo
     * @return
     */
    @RequestMapping(value = "/re-send-message", method = RequestMethod.PUT)
    public CommonDataJsonResponse<MessageDto> reSendMessage(@RequestBody ConfirmMessageVo confirmMessageVo);


    /**
     * 上游业务失败,业务预存储的消息
     *
     * @param confirmMessageVo
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public CommonDataJsonResponse deleteBizFailMessage(@RequestBody ConfirmMessageVo confirmMessageVo);


    /**
     * 下游业务手动确认消息已经消费
     *
     * @param confirmMessageVo
     * @return
     */
    @RequestMapping(value = "/confirm-message", method = RequestMethod.DELETE)
    public CommonDataJsonResponse<MessageDto> confirmMessage(@RequestBody ConfirmMessageVo confirmMessageVo);


    /**
     * 根据获取消息
     *
     * @param id
     * @param correlationId
     * @return
     */
    @RequestMapping(value = "/{id}/{correlationId}", method = RequestMethod.GET)
    public CommonDataJsonResponse<MessageDto> getMessageByDeliverTag(@PathVariable Long id, @PathVariable String correlationId);


    /**
     * 分页获取未确认消息
     *
     * @param page
     * @param row
     * @return
     */
    @RequestMapping(value = "/page/{page}/row/{row}", method = RequestMethod.GET)
    public CommonDataJsonResponse<List<MessageDto>> getMessages(@PathVariable Integer page, @PathVariable Integer row);

    /**
     * 分页获取认定为死亡的消息（重发次数达到一定的值）
     *
     * @return
     */
    @RequestMapping(value = "/dead/page/{page}/row/{row}", method = RequestMethod.GET)
    public CommonDataJsonResponse<MessageDto> getDeadMessage(@PathVariable Integer page, @PathVariable Integer row);

    /**
     * 重发死亡的消息
     *
     * @return
     */
    @RequestMapping(value = "/dead/send", method = RequestMethod.PUT)
    public CommonDataJsonResponse reSendDeadMessage(@RequestBody ConfirmMessageVo confirmMessageVo);

}
