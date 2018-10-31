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
     * 发送一个邮件
     * @param content
     * @return
     */
    @RequestMapping(value = "send", method = RequestMethod.GET)
    private Map<String, Object> sendMail(String content){
        Map<String, Object> modelMap = new HashMap<String, Object>();


        return modelMap;
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    private JsonResult get(String content){
        return JsonResult.ok();
    }
}
