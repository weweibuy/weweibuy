package com.weweibuy.webuy.support.service.impl;

import com.weweibuy.webuy.support.service.SmsCodeService;
import com.weweibuy.webuy.common.utils.CodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SmsCodeServiceImpl
 * @Description
 * @Author durenhao
 * @Date 2019/1/19 22:13
 **/
@Slf4j
@Service
public class SmsCodeServiceImpl implements SmsCodeService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "SMS:CODE:";

    private static final Integer CODE_LENGTH = 6;

    private static final Long EXPIRE_IN_MINUTES = 30L;

    @Override
    public void sendSmsCode(String mobile) {
        String smsCode = CodeUtils.getSmsCode(CODE_LENGTH);
        log.info("验证码: {}", smsCode);
        redisTemplate.opsForValue().set(KEY_PREFIX + mobile, smsCode,
                EXPIRE_IN_MINUTES, TimeUnit.MINUTES);
    }

    @Override
    public String getSmsCode(String mobile) {
        return redisTemplate.opsForValue().get(KEY_PREFIX + mobile);
    }
}
