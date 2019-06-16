package com.weweibuy.webuy.learning.spring.config.properties;

import com.weweibuy.webuy.common.eum.CommonWebMsg;
import com.weweibuy.webuy.learning.spring.model.eum.SystemEum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author durenhao
 * @date 2019/6/13 22:38
 **/
@Data
@ConfigurationProperties(prefix = "code.mapping")
public class CodeMappingProperties {

    private Map<SystemEum, Map<String, CommonWebMsg>> codeMapping;


//    @Data
//    public static class CodeMapping {
//
//        private Map<String, OtherCodeAndMsg> otherCodeAndMsg;
//    }

    @Data
    public static class OtherCodeAndMsg {

        private String code;

        private String msg;

    }

}
