package com.weweibuy.auth.core.validate.code;

import com.weweibuy.auth.core.config.eum.ValidateCodeType;
import com.weweibuy.auth.core.exception.ValidateCodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 持有所有的验证处理的实现
 * @ClassName ValidateCodeProcessorHolder
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 19:10
 **/
@Component
@Slf4j
public class ValidateCodeProcessorHolder {

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessorMap;

    public ValidateCodeProcessor getValidateCodeProcessor(ValidateCodeType validateCodeType){
        return getValidateCodeProcessor(validateCodeType.toString());
    }

    public ValidateCodeProcessor getValidateCodeProcessor(String type){
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor validateCodeProcessor = validateCodeProcessorMap.get(name);
        if(validateCodeProcessor == null){
            log.info("验证码处理器:{} 不存在", name);
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }else {
            return validateCodeProcessor;
        }
    }

}
