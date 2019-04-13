package com.lxmajs.library.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
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
     * ------------
     * 字符串
     * ------------
     */

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
     * ------------
     * 哈希表
     * ------------
     */

    /**
     * 实现命令：HSET key field value，将哈希表 key中的域 field的值设为 value
     * @param key
     * @param field
     * @param value
     */
    public void hset(String key, String field, Object value){
        redisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 实现命令：HGET key field，返回哈希表 key中给定域 field的值
     * @param key
     * @param field
     * @return
     */
    public String hget(String key, String field){
        return (String)redisTemplate.opsForHash().get(key, field);
    }

    /**
     * HDEL key field [field ...]，删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     * @param key
     * @param field
     */
    public void hdel(String key, String field){
        redisTemplate.opsForHash().delete(key, field);
    }

    /**
     * 实现命令：HGETALL key，返回哈希表 key中，所有的域和值。
     * @param key
     * @return
     */
    public Map<Object, Object> hgetall(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * ------------
     * 列表
     * ------------
     */

    /**
     * 实现命令：LPUSH key value，将一个值 value插入到列表 key的表头
     * @param key
     * @param value
     */
    public void lpush(String key, String value){
        redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 实现命令：RPUSH key value，将一个值 value插入到列表 key的表尾(最右边)。
     * @param key
     * @param val
     */
    public void rpush(String key, String val){
        redisTemplate.opsForList().rightPush(key, val);
    }

    /**
     * 实现命令：LPOP key，移除并返回列表 key的头元素。
     * @param key
     * @return
     */
    public String lpop(String key){
        return (String)redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 实现命令：RPOP key，移除并返回列表 key的尾元素。
     * @param key
     * @return
     */
    public String rpop(String key){
        return (String)redisTemplate.opsForList().rightPop(key);
    }
}
