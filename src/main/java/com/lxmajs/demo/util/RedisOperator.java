package com.lxmajs.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 该类是魔方风间影月老师的redis操作累编写的工具类
 * 可实现redis的常规操作
 */
@Component
public class RedisOperator {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 返回某个键值对的ttl
     * @param key
     * @return
     */
    public long ttl(String key){
        return redisTemplate.getExpire(key);
    }

    /**
     * 设置过期时间
     * @param key
     * @param timeout
     */
    public void expire(String key, long timeout){
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 实现incr，增加key一次
     * @param key
     * @param delta
     * @return
     */
    public long incr(String key, long delta){
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 获取key的集合
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern){
        return redisTemplate.keys(pattern);
    }

    /**
     * 删除某个键值对
     * @param key
     */
    public void delete(String key){
        redisTemplate.delete(key);
    }

    /**
     * 添加&设置一个键值对
     * @param key
     * @param value
     */
    public void set(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置一个键值对，过期时间以秒为单位
     * @param key
     * @param value
     * @param timeout
     */
    public void set(String key, String value, long timeout){
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 获得某个键值对的值，并强制类型转换为字符串返回
     * 若为对象，有可能返回类型名(?)
     * @param key
     * @return
     */
    public String get(String key){
        return (String)redisTemplate.opsForValue().get(key);
    }

    /**
     * 实现命令：HSET key field value，将哈希表 key中的域 field的值设为 value
     * @param key
     * @param field
     * @param value
     */
    public void hset(String key, String field, Object value){
        redisTemplate.opsForHash().put(key, field, value);
    }

}
