package com.weweibuy.webuy.support.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName MailUtil
 * @Description
 * @Author durenhao
 * @Date 2018/11/28 23:32
 **/
@Component
public class MailUtil {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String mailSenderName;

    private static JavaMailSender jms;

    private static String MAIL_SENDER_NAME;

    @PostConstruct
    public void init(){
        MAIL_SENDER_NAME = mailSenderName;
        jms = mailSender;
    }

    /**
     *  发送邮件
     * @param receiver 接受者
     * @param subject 主题
     * @param text 内容
     * @return
     */
    public static void send(String  receiver, String subject, String text) {
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom(MAIL_SENDER_NAME);
        //接收者
        mainMessage.setTo(receiver);
        //发送的标题
        mainMessage.setSubject(subject);
        //发送的内容
        mainMessage.setText(text);
        jms.send(mainMessage);
    }
}
