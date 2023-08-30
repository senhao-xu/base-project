package com.tomato.common.exception.base;

import com.alibaba.fastjson.JSONObject;
import com.tomato.common.enums.base.BaseCodeEnum;

/**
 * @author Tomato
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -1L;
    private String code;
    private String message;

    public BaseException(String code) {
        this.code = code;
    }

    public BaseException(BaseCodeEnum baseCodeEnum) {
        this.code = baseCodeEnum.getCode();
        this.message = baseCodeEnum.getMessage();
    }

    public BaseException(BaseCodeEnum baseCodeEnum, String message) {
        super(message);
        this.code = baseCodeEnum.getCode();
        this.message = baseCodeEnum.getMessage();
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(String code, String message, String msg) {
        super(msg);
        this.code = code;
        this.message = message;
    }

    public BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public BaseException(String code, String message, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.message = message;
    }

    public int getCodeIntValue() {
        return Integer.valueOf(this.code);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
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