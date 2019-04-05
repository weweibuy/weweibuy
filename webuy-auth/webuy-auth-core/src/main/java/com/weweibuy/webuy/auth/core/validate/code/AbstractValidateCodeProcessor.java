package com.weweibuy.webuy.auth.core.validate.code;

import com.weweibuy.webuy.auth.core.config.eum.ValidateCodeType;
import com.weweibuy.webuy.auth.core.exception.ValidateCodeException;
import com.weweibuy.webuy.auth.core.model.vo.ValidateCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @ClassName AbstractValidateCodeProcessor
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 10:18
 **/
@Slf4j
public abstract class AbstractValidateCodeProcessor <T extends ValidateCode> implements ValidateCodeProcessor {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGeneratorMap;

    @Override
    public void create(ServletWebRequest request){
        T validateCode = generator();
        save(request, validateCode);
        send(request, validateCode);
    }

    @Override
    public void validate(ServletWebRequest request){
        String sessionKey = getSessionKey();
        ValidateCode sessionValidateCode = (ValidateCode)sessionStrategy.getAttribute(request, sessionKey);
        String requestSmsCode;
        try {
            requestSmsCode = ServletRequestUtils.getStringParameter(request.getRequest(),
                    getValidateCodeType().getParamName());
        } catch (ServletRequestBindingException e) {
            log.info("【验证码验证】：无法获取请求中的验证码");
            throw new ValidateCodeException("无法获取请求中的验证码");
        }

        if(StringUtils.isEmpty(requestSmsCode)){
            throw new ValidateCodeException("请求中的验证码为空");
        }
        if(sessionValidateCode == null || StringUtils.isEmpty(sessionValidateCode.getCode())
                || sessionValidateCode.isExpired()){
            throw new ValidateCodeException("验证码不存在, 或已经失效");
        }
        if(!requestSmsCode.equals(sessionValidateCode.getCode())){
            throw new ValidateCodeException("验证码错误");
        }
        sessionStrategy.removeAttribute(request, sessionKey);
    }

    private T generator(){
        String validateName = getValidateCodeType().toString().toLowerCase() + "ValidateCodeGenerator";
        ValidateCodeGenerator validateCodeGenerator = validateCodeGeneratorMap.get(validateName);
        if(validateCodeGenerator == null){
            log.error("验证器:{}不存在", validateName);
            throw new ValidateCodeException("验证器"+ validateName +"不存在");
        }
        return (T)validateCodeGenerator.generator();
    }

    /**
     * 保存验证码
     * @param request
     * @param validateCode
     */
    private void save(ServletWebRequest request, T validateCode){
        sessionStrategy.setAttribute(request, getSessionKey(), validateCode);
    }

    protected abstract void send(ServletWebRequest request, T validateCode);

    /**
     * 获取存储code的key；实现类不同，key不同
     * @return
     */
    private String getSessionKey(){
        return SESSION_PREFIX + getClass().getSimpleName().toUpperCase();
    }

    /**
     * 根据实现类名 ValidateCodeProcessor 前面的字母判断验证方式
     * @return
     */
    private ValidateCodeType getValidateCodeType(){
        return ValidateCodeType.valueOf(org.apache.commons.lang3.StringUtils.substringBefore(getClass().getSimpleName(),
                "ValidateCodeProcessor").toUpperCase());

    }

}
