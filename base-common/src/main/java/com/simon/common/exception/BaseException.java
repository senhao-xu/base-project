package com.simon.common.exception;

import com.alibaba.fastjson.JSONObject;
import com.simon.common.enums.BaseResponseEnum;

/**
 * @author Tomato
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -1L;
    private Integer code;
    private String message;

    public BaseException(Integer code) {
        this.code = code;
    }

    public BaseException(BaseResponseEnum baseCodeEnum) {
        this.code = baseCodeEnum.getCode();
        this.message = baseCodeEnum.getMessage();
    }

    public BaseException(BaseResponseEnum baseCodeEnum, String message) {
        super(message);
        this.code = baseCodeEnum.getCode();
        this.message = baseCodeEnum.getMessage();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer code, String message, String msg) {
        super(msg);
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer code, String message, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.message = message;
    }

    public int getCodeIntValue() {
        return Integer.valueOf(this.code);
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJSONString() {
        JSONObject object = new JSONObject();
        object.put("code", this.code);
        object.put("message", this.message);
        return object.toString();
    }

    public Throwable fillInStackTrace() {
        return this;
    }
}