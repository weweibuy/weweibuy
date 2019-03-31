package com.weweibuy.message.client.fallback;

import com.weweibuy.common.dto.CommonJsonResponse;
import com.weweibuy.common.eum.CommonWebMsg;
import com.weweibuy.message.client.MessageClient;
import com.weweibuy.message.common.model.dto.MessageDto;
import com.weweibuy.message.common.model.po.WebuyMessage;
import com.weweibuy.message.common.model.vo.MessageVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName MessageClientFallBack
 * @Description
 * @Author durenhao
 * @Date 2019/3/31 22:36
 **/
@Slf4j
@Component
public class MessageClientFallBack implements FallbackFactory<MessageClient> {

    @Override
    public MessageClient create(Throwable throwable) {
        return new MessageClient() {
            @Override
            public CommonJsonResponse<MessageDto> saveMessage(MessageVo message) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<MessageDto> sendMessage(WebuyMessage message) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<MessageDto> confirmMessage(String deliverTag) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<MessageDto> getMessageById(Long id) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<MessageDto> getMessageByDeliverTag(String deliverTag) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<MessageDto> getMessages() {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<MessageDto> getDeadMessage() {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<MessageDto> reSendDeadMessage() {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }
        };
    }
}
