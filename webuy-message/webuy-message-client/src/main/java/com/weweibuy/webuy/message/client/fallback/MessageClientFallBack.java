package com.weweibuy.webuy.message.client.fallback;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.framework.common.core.model.eum.CommonErrorCodeEum;
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
            public CommonDataResponse<MessageDto> saveMessage(PreSaveMessageVo message, BindingResult result) {
                return CommonDataResponse.response(CommonErrorCodeEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataResponse<MessageDto> sendMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonDataResponse.response(CommonErrorCodeEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataResponse<MessageDto> reSendMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonDataResponse.response(CommonErrorCodeEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataResponse deleteBizFailMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonDataResponse.response(CommonErrorCodeEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataResponse<MessageDto> confirmMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonDataResponse.response(CommonErrorCodeEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataResponse<MessageDto> getMessageByDeliverTag(Long id, String correlationId) {
                return CommonDataResponse.response(CommonErrorCodeEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataResponse<List<MessageDto>> getMessages(Integer page, Integer row) {
                return CommonDataResponse.response(CommonErrorCodeEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataResponse<MessageDto> getDeadMessage(Integer page, Integer row) {
                return CommonDataResponse.response(CommonErrorCodeEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataResponse reSendDeadMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonDataResponse.response(CommonErrorCodeEum.UNKNOWN_EXCEPTION, null);
            }
        };
    }
}
