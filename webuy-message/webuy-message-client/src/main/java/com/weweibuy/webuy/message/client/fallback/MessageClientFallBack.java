package com.weweibuy.webuy.message.client.fallback;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.common.eum.CommonWebMsg;
import com.weweibuy.webuy.message.client.MessageClient;
import com.weweibuy.webuy.message.common.model.dto.MessageDto;
import com.weweibuy.webuy.message.common.model.vo.ConfirmMessageVo;
import com.weweibuy.webuy.message.common.model.vo.PreSaveMessageVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * @ClassName MessageClientFallBack
 * @Description
 * @Author durenhao
 * @Date 2019/2/31 22:36
 **/
@Slf4j
@Component
public class MessageClientFallBack implements FallbackFactory<MessageClient> {

    @Override
    public MessageClient create(Throwable throwable) {
        return new MessageClient() {
            @Override
            public CommonJsonResponse<MessageDto> saveMessage(PreSaveMessageVo message, BindingResult result) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<MessageDto> sendMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<MessageDto> reSendMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse deleteBizFailMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<MessageDto> confirmMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<MessageDto> getMessageByDeliverTag(Long id, String correlationId) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<List<MessageDto>> getMessages(Integer page, Integer row) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse<MessageDto> getDeadMessage(Integer page, Integer row) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse reSendDeadMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }
        };
    }
}
