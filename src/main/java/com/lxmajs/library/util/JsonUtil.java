package com.lxmajs.library.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 该帮助类定义了一些jackson的帮助方法，用于转换对象为json或将json解析为某些类的对象实例
 * 该类学习自 风间影月老师的 JsonUtil类
 */
public class JsonUtil {

    /**
     * 定义jackson对象
     */
    private static final ObjectMapper Mapper = new ObjectMapper();

    /**
     * 将某个类转换为json字符串
     * @param data
     * @return
     */
    public static String objectToJson(Object data){
        try{
            String json = Mapper.writeValueAsString(data);
            return json;
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json字符串转化为类的对象
     * @param data
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> T jsonToPojo(String data, Class<T> beanType){
        try{
            T t = Mapper.readValue(data, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json字符串转化为类对象的列表
     * @param data
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String data, Class<T> beanType){
        JavaType javaType = Mapper.getTypeFactory().constructParametricType(List.class, beanType);
        try{
            List<T> list = Mapper.readValue(data, javaType);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
