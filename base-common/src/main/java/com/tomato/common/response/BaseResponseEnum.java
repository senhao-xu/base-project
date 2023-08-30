package com.tomato.common.response;

/**
 * 统一返回的常量类
 *  * 对内修改开放，对外修改关闭---枚举
 * @author senhao-xu
 * @time: 2021/6/23 22:12
 */
public enum BaseResponseEnum {
    /**
     * SUCCESS
     **/
    SUCCESS(200000, "成功!"),


    /**
     * ERROR
     **/
    SERVER_ERROR(500000, "服务端异常"),

    ;

    private Integer code;
    private String message;

    BaseResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
