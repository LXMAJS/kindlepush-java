package com.lxmajs.demo.web;


import com.lxmajs.demo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailControllerTest {

    @Resource
    private MailService mailService;

    @Test
    public void sendMailTest(){
        mailService.sendSimpleMail("lxmajs@163.com", "hello world", "没什么事，就是发一个邮件");
    }

    @Test
    public void sendHtmlMailTest() throws MessagingException {
        String content = "<html>"+
                    "<body>" +
                        "<h3>这是一个html的邮件的内容</h3>" +
                    "</body>" +
                "</html>";
        mailService.sendHtmlMail("lxmajs@163.com", "这是一封html邮件", content);
    }
}
