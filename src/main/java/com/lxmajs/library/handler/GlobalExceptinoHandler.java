package com.lxmajs.library.handler;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptinoHandler {
    /**
     * 统一的错误处理返回类
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String, Object> ExceptionHandler(HttpServletRequest req, Exception e){
        Map<String, Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success", false);
        modelMap.put("errMsg", e.getMessage());

        return modelMap;
    }

    /**
     * 邮件发送失败的错误处理类
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MessagingException.class)
    @ResponseBody
    private Map<String, Object> MessagingExceptionHandler(HttpServletRequest req, MessagingException e){
        Map<String, Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success", false);
        modelMap.put("errMsg", "邮件发送失败：" + e.getMessage());

        return modelMap;
    }

}
