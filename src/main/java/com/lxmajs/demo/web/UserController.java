package com.lxmajs.demo.web;

import com.lxmajs.demo.model.WXSessionModel;
import com.lxmajs.demo.util.JsonUtil;
import com.lxmajs.demo.util.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisOperator redisOperator;

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
        Map<String, String> param = new HashMap<String, String>();
        param.put("appId", "");


        // 发起远程请求微信付武器的接口，获取登录的sessionkey
        String wxResult = "";
        WXSessionModel model = JsonUtil.jsonToPojo(wxResult, WXSessionModel.class);

        // 将session存入redis中
        String redisKey = "user-redis-session:" + model.getOpenid();
        String redisValue = model.getSession_key();
        long redisTimeout = 1000 * 60 * 30;
        redisOperator.set(redisKey, redisValue, redisTimeout);

        return modelMap;
    }
}
