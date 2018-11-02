package com.lxmajs.demo.web;

import com.lxmajs.demo.model.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mail")
public class MailController {
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
        return JsonResult.ok();
    }
}
