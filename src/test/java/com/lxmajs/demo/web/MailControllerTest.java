package com.lxmajs.demo.web;


import com.lxmajs.demo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailControllerTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendMailTest(){
        mailService.sendSimpleMail("lxmajs@163.com", "hello world", "没什么事，就是发一个邮件");
    }
}
