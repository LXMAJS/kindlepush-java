package com.lxmajs.library.web;

import com.lxmajs.library.model.JsonResult;
import com.lxmajs.library.model.WXSessionModel;
import com.lxmajs.library.util.HttpClientUtil;
import com.lxmajs.library.util.JsonUtil;
import com.lxmajs.library.util.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisOperator redisOperator;

    @Value("${wx.miniprogram.loginUrl}")
    private String wxMiniprogramLoginUrl;

    @Value("${wx.miniprogram.appId}")
    private String wxMiniprogramAppId;

    @Value("${wx.miniprogram.secret}")
    private String wxMiniprogramSecret;

    /**
     * 微信用户登录
     * @return
     */
    @RequestMapping(value = "wxlogin", method = RequestMethod.POST)
    private JsonResult wxLogin(String code){

        Map<String, String> param = new HashMap<String, String>();
        param.put("appId", wxMiniprogramAppId);
        param.put("secret", wxMiniprogramSecret);
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        // 发起远程请求微信付武器的接口，获取登录的sessionkey
        String wxResult = HttpClientUtil.post(wxMiniprogramLoginUrl, param);
        System.out.print(wxResult);
        WXSessionModel model = JsonUtil.jsonToPojo(wxResult, WXSessionModel.class);

        // 将session存入redis中
        String redisKey = "user-redis-session:" + model.getOpenid();
        String redisValue = model.getSession_key();
        long redisTimeout = 1000 * 60 * 30;
        redisOperator.set(redisKey, redisValue, redisTimeout);


        return JsonResult.ok();
    }

    /**
     * 后台管理员登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "adminlogin", method = RequestMethod.POST)
    private JsonResult adminLogin(String username, String password){

        return JsonResult.ok();
    }
}
