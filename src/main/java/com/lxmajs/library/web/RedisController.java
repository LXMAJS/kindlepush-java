package com.lxmajs.library.web;

import com.lxmajs.library.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;

    @RequestMapping("/test")
    public JsonResult test(){
        strRedis.opsForValue().set("hello", "world");
        return JsonResult.ok(strRedis.opsForValue().get("hello"));
    }
}
