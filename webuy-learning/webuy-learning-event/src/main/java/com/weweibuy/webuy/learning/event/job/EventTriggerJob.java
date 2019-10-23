package com.weweibuy.webuy.learning.event.job;

import com.weweibuy.webuy.learning.event.mapper.BizEventConfigMapper;
import com.weweibuy.webuy.learning.event.mapper.BizEventMapper;
import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import com.weweibuy.webuy.learning.event.model.po.BizEventConfig;
import com.weweibuy.webuy.learning.event.model.po.BizEventExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2019/10/23 22:12
 **/
@Slf4j
@Component
public class EventTriggerJob implements InitializingBean {

    @Autowired
    private BizEventMapper bizEventMapper;

    @Autowired
    private BizEventConfigMapper bizEventConfigMapper;

    private Map<String, BizEventConfig> configMap;

    @Scheduled(cron = "*/30 * * * * ?")
    public void triggerEvent() {
        log.info("job 触发了");
        BizEventExample bizEventExample = new BizEventExample();
        bizEventExample.createCriteria().andIsDeleteEqualTo(false);
        List<BizEvent> bizEvents = bizEventMapper.selectByExample(bizEventExample);

    }


    @Override
    public void afterPropertiesSet() throws Exception {

        List<BizEventConfig> bizEventConfigs = bizEventConfigMapper.selectByExample(null);
        configMap = bizEventConfigs.stream().collect(Collectors.toMap(BizEventConfig::getEventType, i -> i));
    }
}
