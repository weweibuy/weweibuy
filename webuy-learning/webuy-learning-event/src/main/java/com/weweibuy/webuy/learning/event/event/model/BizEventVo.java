/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learning.event.event.model;

import com.weweibuy.webuy.learning.event.event.trigger.TriggerType;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author durenhao
 * @date 2019/10/28 10:01
 **/
@Data
public class BizEventVo {

    private static final BeanCopier COPIER = BeanCopier.create(BizEvent.class, BizEventVo.class, false);

    private static final BeanCopier TO_COPIER = BeanCopier.create(BizEventVo.class, BizEvent.class, false);

    private Long id;

    private TriggerType triggerType;

    private List<BizEventVo> child;

    private String eventNo;

    private String bizNo;

    private String eventType;

    private String eventStatus;

    private Integer retryCount;

    private Integer alarmCount;

    private String eventBody;

    private Object body;

    private String parentId;

    private Boolean isParent;

    private Integer eventOrder;

    private Boolean isDelete;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public static BizEventVo fromDb(BizEvent bizEvent) {
        BizEventVo bizEventVo = new BizEventVo();
        COPIER.copy(bizEvent, bizEventVo, null);
        bizEventVo.setTriggerType(TriggerType.JOB_JDBC);
        return bizEventVo;
    }


    public BizEvent toBizEvent() {
        BizEvent bizEvent = new BizEvent();
        TO_COPIER.copy(this, bizEvent, null);
        return bizEvent;
    }

}
