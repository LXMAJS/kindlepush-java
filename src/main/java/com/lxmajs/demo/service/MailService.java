package com.lxmajs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
public class MailService {

    /**
     * 配置文件中的发送人
     */
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 邮件发送帮助类
     */
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送简单邮件
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String to, String subject, String content){
        // 设置邮件主题、接收人、邮件内容等参数
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(from);

        mailSender.send(message);
    }

    /**
     * 发送html邮件内容的简单邮件
     * @param to
     * @param subject
     * @param htmlContent
     * @throws MessagingException
     */
    public void sendHtmlMail(String to, String subject, String htmlContent) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);
        helper.setFrom(from);

        mailSender.send(message);
    }


    /**
     * 发送带一个附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws MessagingException
     */
    public void sendAttachmentMail(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setFrom(from);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = file.getFilename();
        helper.addAttachment(fileName, file);

        mailSender.send(message);
    }

    /**
     * 发送很多附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePaths
     * @throws MessagingException
     */
    public void sendAttachmentsMail(String to, String subject, String content, List<String> filePaths) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setFrom(from);


        if(filePaths.size() > 0) {
            for (int i = 0; i > filePaths.size(); i ++) {
                FileSystemResource file = new FileSystemResource(new File(filePaths.get(i)));
                String fileName = file.getFilename();
                helper.addAttachment(fileName, file);
            }
        }

        mailSender.send(message);
    }

    /**
     *
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscPath
     */
    public void sendInLinResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setFrom(from);

        FileSystemResource file = new FileSystemResource(new File(rscPath));
        helper.addInline(rscId, file);
        mailSender.send(message);
    }
}
