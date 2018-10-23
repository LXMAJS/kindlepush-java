package com.lxmajs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    /**
     * 配置文件中的发送
     */
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 邮件发送帮助类
     */
    @Autowired
    private JavaMailSender mailSender;

    /**
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String to, String subject, String content){
        System.out.print("hehe:" + from);
        SimpleMailMessage message = new SimpleMailMessage();

        System.out.print("1");
        message.setTo(to);

        System.out.print("2");
        message.setSubject(subject);

        System.out.print("3");
        message.setText(content);

        System.out.print("4");
        message.setFrom(from);


        System.out.print("5");
        mailSender.send(message);

        System.out.print("6");
    }
}
