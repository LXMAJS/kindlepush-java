package com.lxmajs.demo.web;


import com.lxmajs.demo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.Hashtable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailControllerTest {

    @Resource
    private MailService mailService;

    @Resource
    private TemplateEngine templateEngine;

    private String to = "lxmajs@163.com";

    @Test
    public void sendMailTest(){
        mailService.sendSimpleMail(to, "hello world", "没什么事，就是发一个邮件");
    }

    @Test
    public void sendHtmlMailTest() throws MessagingException {
        String content = "<html>"+
                    "<body>" +
                        "<h3>这是一个html的邮件的内容</h3>" +
                    "</body>" +
                "</html>";
        mailService.sendHtmlMail(to, "这是一封html邮件", content);
    }

    @Test
    public void sendAttachmentMailTest() throws MessagingException {
        String content = "<html>"+
                "<body>" +
                "<h3>这是一个带有附件的邮件</h3>" +
                "</body>" +
                "</html>";
        String filePath = "/Users/lijin/Documents/Document/R0000025.DNG";
        mailService.sendAttachmentMail(to, "这是一封html邮件", content, filePath);

    }

    @Test
    public void sendInLinResourceMailTest() throws MessagingException {
        String content = "<html>"+
                "<body>" +
                "<h3>这是一个带有附件的邮件</h3>" +
                "<img src=\'cid:\"001\"\' />" +
                "</body>" +
                "</html>";
        String filePath = "/Users/lijin/Documents/Document/R0000025.DNG";
        mailService.sendInlineResourceMail(to, "这是一封html邮件", content, filePath, "001");
    }


    @Test
    public void sendTemplateMail() throws MessagingException {
        Context context = new Context();
        context.setVariable("id", "8886562");

        String emailContent = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail(to, "这是一封模板邮件", emailContent);
    }
}
