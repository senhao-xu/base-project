package com.simon.common.response;


import com.simon.common.enums.BaseResponseEnum;

/**
 * 全局API接口返回类
 * @author senhao-xu
 * @date: 2021/7/31 14:47
 */
public class BaseResponse<T> {

    /** 返回的编号 */
    private Integer code;
    /** 返回的信息 */
    private String message;
    /** 返回的数据,数据类型N中*/
    private T data;

    private BaseResponse() {

    }

    /**
     * @Description 成功返回
     * @Date 21:55 2021/6/23
     * @Param []
     **/
    public static <T> BaseResponse<T> success(T data, String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(BaseResponseEnum.SUCCESS.getCode());
        baseResponse.setData(data);
        baseResponse.setMessage(message == null ? BaseResponseEnum.SUCCESS.getMessage() : message);
        return baseResponse;
    }

    /**
     * @Description 成功返回
     * @Date 21:55 2021/6/23
     * @Param []
     **/
    public static <T> BaseResponse<T> success(T data) {
        return success(data, null);
    }

    /**
     * 成功返回默认的
     * @return
     */
    public static <T> BaseResponse<T> success() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(BaseResponseEnum.SUCCESS.getCode());
        baseResponse.setData(null);
        baseResponse.setMessage(BaseResponseEnum.SUCCESS.getMessage());
        return baseResponse;
    }

    /**
     * 成功返回默认的
     * @return
     */
    public static <T> BaseResponse<T> success(BaseResponseEnum responseEnum) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(responseEnum.getCode());
        baseResponse.setData(null);
        baseResponse.setMessage(responseEnum.getMessage());
        return baseResponse;
    }


    /**
     * @Description
     * @Date 22:03 2021/6/23
     * @Param [code 失败的状态, message 失败的原因]
     **/
    public static <T> BaseResponse<T> error(Integer code, String message) {
        BaseResponse baseResponse= new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setData(null);
        baseResponse.setMessage(message);
        return baseResponse;
    }

    /**
     * @Description
     * @Date 22:03 2021/6/23
     * @Param [code 失败的状态, message 失败的原因]
     **/
    public static <T> BaseResponse<T> error(BaseResponseEnum responseEnum) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(responseEnum.getCode());
        baseResponse.setData(null);
        baseResponse.setMessage(responseEnum.getMessage());
        return baseResponse;
    }


    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) { this.code = code; }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
