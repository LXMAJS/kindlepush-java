package com.lxmajs.demo.model;

import com.lxmajs.demo.util.JsonResultStatus;

/**
 * @author lxmajs
 * @title json对象的返回
 * @date 2018/10/31
 */
public class JsonResult {
    /**
     *
     */
    private Integer status;

    /**
     *
     */
    private String msg;

    /**
     *
     */
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult() {}

    /**
     *
     * @param status
     * @param msg
     * @param data
     */
    public JsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     *
     * @param status
     * @param msg
     * @param data
     * @return
     */
    public static JsonResult build(Integer status, String msg, Object data){
        return new JsonResult(status, msg, data);
    }

    /**
     *
     * @param data
     * @return
     */
    public static JsonResult ok(Object data){
        return new JsonResult(JsonResultStatus.Success, null, data);
    }

    /**
     *
     * @return
     */
    public static JsonResult ok(){
        return new JsonResult(JsonResultStatus.Success, null, null);
    }

    /**
     *
     * @param msg
     * @return
     */
    public static JsonResult error(String msg){
        return new JsonResult(JsonResultStatus.Error, msg, null);
    }

    /**
     *
     * @param data
     * @return
     */
    public static JsonResult errorMap(Object data){
        return new JsonResult(JsonResultStatus.Error_Bean, "error", data);
    }

    /**
     *
     * @param msg
     * @return
     */
    public static JsonResult errorToken(String msg){
        return new JsonResult(JsonResultStatus.Error_Token, msg, null);
    }

    /**
     *
     * @param msg
     * @return
     */
    public static JsonResult errorException(String msg){
        return new JsonResult(JsonResultStatus.Error_Other, msg, null);
    }

    /**
     *
     * @return
     */
    public boolean isOk(){
        return this.status == JsonResultStatus.Success;
    }
}
