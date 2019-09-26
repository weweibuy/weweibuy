package com.weweibuy.webuy.learning.event.model.event.biz;

import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.cglib.beans.BeanCopier;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2019/9/21 21:41
 **/
@ToString
@Data
@Builder
public class BizEventVo {

    private static final BeanCopier COPIER = BeanCopier.create(BizEventVo.class, BizEvent.class, false);

    private Long id;

    private String bizId;

    private String bizType;

    private String eventType;

    private String eventStatus;

    private Byte triggerType;

    private String blockThreshold;

    private String retryRule;

    private Integer retryCount;

    private String alarmRule;

    private Integer alarmCount;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long timestamp;

    public static BizEvent toBizEvent(BizEventVo vo) {
        BizEvent bizEvent = new BizEvent();
        COPIER.copy(vo, bizEvent, null);
        return bizEvent;
    }


}
