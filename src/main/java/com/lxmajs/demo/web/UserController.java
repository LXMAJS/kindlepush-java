package com.lxmajs.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 微信用户登录
     * @return
     */
    @RequestMapping(value = "wxlogin", method = RequestMethod.POST)
    private Map<String, Object> wxLogin(String code){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.print("wx-code: " +code);
        modelMap.put("success", true);
        modelMap.put("code", code);

        String url = "https://api.weixin.qq.com/sns/jscode2session";



        return modelMap;
    }
}
