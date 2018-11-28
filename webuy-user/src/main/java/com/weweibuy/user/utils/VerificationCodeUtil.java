package com.weweibuy.user.utils;

import com.alibaba.fastjson.JSONObject;
import com.weweibuy.user.model.vo.PhoneVerifyCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName VerificationCodeUtil
 * @Description 验证码工具
 * @Author durenhao
 * @Date 2018/11/26 23:04
 **/
@Component
public class VerificationCodeUtil {

    @Autowired
    private StringRedisTemplate StringRedisTemplate;

    private static StringRedisTemplate redisTemplate;

    private static final Long VERIFICATION_CODE_EXPIRE_TIME = 600L;

    private static final String VERIFICATION_CODE_PREFIX = "phone_verification_code:";

    private static final Long SEND_SPACE = 45000L;

    @PostConstruct
    public void init(){
        redisTemplate = StringRedisTemplate;
    }

    /**
     * 发送手机验证码，过期时间10分钟
     * @param phoneNum
     * @return
     */
    public static boolean sendVerificationCode(String phoneNum){
        redisTemplate.opsForValue().set(VERIFICATION_CODE_PREFIX + phoneNum,
                JSONObject.toJSONString(new PhoneVerifyCodeVo(CodeUtil.getPhoneVerificationCode(),
                        System.currentTimeMillis())), VERIFICATION_CODE_EXPIRE_TIME, TimeUnit.SECONDS);
        // TODO 发送验证码
        return true;
    }

    /**
     * 获取验证码
     * @param phoneNum
     * @return 不存在返回null;
     */
    public static String getVerificationCode(String phoneNum){
        String json = redisTemplate.opsForValue().get(VERIFICATION_CODE_PREFIX + phoneNum);
        if(json == null){
            return null;
        }
        return JSONObject.parseObject(json, PhoneVerifyCodeVo.class).getCode()+"";
    }

    /**
     * 是否可以发送验证码，没45s发送一次
     * @param phoneNum
     * @return
     */
    public static boolean canSendPhoneVerifyCode(String phoneNum){
       String json = redisTemplate.opsForValue().get(VERIFICATION_CODE_PREFIX + phoneNum);
       if(json == null || System.currentTimeMillis() - JSONObject.parseObject(json, PhoneVerifyCodeVo.class).getTimeStamp() > SEND_SPACE){
           return true;
       }
       return false;
    }


    /**
     * 获取手机验证码对象
     * @param phoneNum
     * @return
     */
    public static PhoneVerifyCodeVo getPhoneVerifyCodeVo(String phoneNum){
        String json = redisTemplate.opsForValue().get(VERIFICATION_CODE_PREFIX + phoneNum);
        return JSONObject.parseObject(json, PhoneVerifyCodeVo.class);
    }

}
