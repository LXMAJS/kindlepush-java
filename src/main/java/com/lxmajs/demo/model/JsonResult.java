package com.lxmajs.demo.model;

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
    private Boolean success;

    /**
     * 状态码枚举
     */
    public enum EStatus{
        Success(200),
        Error(500),
        Error_Bean(501),
        Error_Token(502),
        Error_Other(555);

        private int code;

        private EStatus(int code){
            this.code = code;
        }
    }

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

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public JsonResult() {}

    /**
     *
     * @param success
     * @param status
     * @param msg
     * @param data
     */
    public JsonResult(Boolean success, Integer status, String msg, Object  data) {
        this.success = success;
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
    public static JsonResult build(Boolean success, Integer status, String msg, Object data){
        return new JsonResult(success, status, msg, data);
    }

    /**
     *
     * @param data
     * @return
     */
    public static JsonResult ok(Object data){
        return new JsonResult(true, EStatus.Success.code, null, data);
    }

    /**
     *
     * @return
     */
    public static JsonResult ok(){
        return new JsonResult(true, EStatus.Success.code, null, null);
    }

    /**
     *
     * @param msg
     * @return
     */
    public static JsonResult error(String msg){
        return new JsonResult(false, EStatus.Error.code, msg, null);
    }

    /**
     *
     * @param data
     * @return
     */
    public static JsonResult errorMap(Object data){
        return new JsonResult(false, EStatus.Error_Bean.code, "error", data);
    }

    /**
     *
     * @param msg
     * @return
     */
    public static JsonResult errorToken(String msg){
        return new JsonResult(false, EStatus.Error_Token.code, msg, null);
    }

    /**
     *
     * @param msg
     * @return
     */
    public static JsonResult errorException(String msg){
        return new JsonResult(false, EStatus.Error_Other.code, msg, null);
    }

    /**
     *
     * @return
     */
    public boolean isOk(){
        return this.status == EStatus.Success.code;
    }
}
