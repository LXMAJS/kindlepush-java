package com.lxmajs.demo.handler;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptinoHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String, Object> ExceptionHandler(HttpServletRequest req, Exception e){
        Map<String, Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success", false);
        modelMap.put("errMsg", e.getMessage());

        return modelMap;
    }

}
