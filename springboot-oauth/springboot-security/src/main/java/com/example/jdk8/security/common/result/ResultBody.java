package com.example.jdk8.security.common.result;

import com.alibaba.fastjson.JSONObject;
import com.example.jdk8.security.common.enums.CommonHandleEnum;
import com.example.jdk8.security.common.exception.BaseErrorInfoInterface;

/**
 * @Classname ResultBody
 * @Description 封装的消息返回体
 * @Date 2024/8/8
 * @Created by zhaojh0912
 */
public class ResultBody<T> {
    /**
     * 响应代码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private T result;

    private BaseErrorInfoInterface errorInfo;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ResultBody(BaseErrorInfoInterface errorInfo) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResultMsg();
    }

    public ResultBody() {

    }
    
    /**
     * 成功
     *
     * @return
     */
    public static <T> ResultBody<T> success() {
        return success(CommonHandleEnum.SUCCESS);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static <T> ResultBody<T> success(T data) {
        ResultBody<T> rb = new ResultBody<T>();
        rb.setCode(CommonHandleEnum.SUCCESS.getResultCode());
        rb.setMessage(CommonHandleEnum.SUCCESS.getResultMsg());
        rb.setResult(data);
        return rb;
    }

    /**
     * 成功
     */
    public static <T> ResultBody<T> success(CommonHandleEnum commonEnum) {
        ResultBody<T> rb = new ResultBody<T>();
        rb.setCode(commonEnum.getResultCode());
        rb.setMessage(commonEnum.getResultMsg());
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static <T> ResultBody<T> error(BaseErrorInfoInterface errorInfo) {
        ResultBody rb = new ResultBody();
        rb.setCode(errorInfo.getResultCode());
        rb.setMessage(errorInfo.getResultMsg());
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static <T> ResultBody<T> error(CommonHandleEnum commonEnum) {
        ResultBody rb = new ResultBody();
        rb.setCode(commonEnum.getResultCode());
        rb.setMessage(commonEnum.getResultMsg());
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static <T> ResultBody<T> error(Integer code, String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static <T> ResultBody<T> error( String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(-1);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}

