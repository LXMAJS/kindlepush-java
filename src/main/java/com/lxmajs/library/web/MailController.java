package com.lxmajs.library.web;

import com.lxmajs.library.entity.User;
import com.lxmajs.library.model.JsonResult;
import com.lxmajs.library.service.MailService;
import com.lxmajs.library.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

    /**
     * 发送邮件的帮助类
     */
    @Autowired
    private MailService mailOperator;

    /**
     * 查找用户的帮助类
     */
    @Autowired
    private UserServiceImpl userService;

    /**
     * 发送一封邮件
     * @param userId
     * @param to
     * @param subject
     * @param content
     * @return
     */
    @RequestMapping(value = "send", method = RequestMethod.GET)
    private JsonResult send(String userId, String to, String subject, String content){
        User user = userService.getUserByUsername(userId);
        if(user == null)
            return JsonResult.error("wrong user");

        mailOperator.sendSimpleMail(user.getUsername(), to, subject, content);
        return JsonResult.ok();
    }
}
