package com.weweibuy.webuy.message.client.fallback;

import com.weweibuy.webuy.common.model.dto.CommonDataJsonResponse;
import com.weweibuy.webuy.common.model.eum.CommonResponseEum;
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
            public CommonDataJsonResponse<MessageDto> saveMessage(PreSaveMessageVo message, BindingResult result) {
                return CommonDataJsonResponse.response(CommonResponseEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataJsonResponse<MessageDto> sendMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonDataJsonResponse.response(CommonResponseEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataJsonResponse<MessageDto> reSendMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonDataJsonResponse.response(CommonResponseEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataJsonResponse deleteBizFailMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonDataJsonResponse.response(CommonResponseEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataJsonResponse<MessageDto> confirmMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonDataJsonResponse.response(CommonResponseEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataJsonResponse<MessageDto> getMessageByDeliverTag(Long id, String correlationId) {
                return CommonDataJsonResponse.response(CommonResponseEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataJsonResponse<List<MessageDto>> getMessages(Integer page, Integer row) {
                return CommonDataJsonResponse.response(CommonResponseEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataJsonResponse<MessageDto> getDeadMessage(Integer page, Integer row) {
                return CommonDataJsonResponse.response(CommonResponseEum.UNKNOWN_EXCEPTION, null);

            }

            @Override
            public CommonDataJsonResponse reSendDeadMessage(ConfirmMessageVo confirmMessageVo) {
                return CommonDataJsonResponse.response(CommonResponseEum.UNKNOWN_EXCEPTION, null);
            }
        };
    }
}
