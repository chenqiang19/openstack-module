package com.ict.cloud.common.analzye;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

/**
 * 通用的结果集封装 （目前项目统一使用）
 */
@ApiModel
@ToString
public class ApiResult<T> {
    public static final int SUCCESS_CODE = 10000;
    public static final int COMMON_FAILED_CODE = 10001;

    @ApiModelProperty(value = "结果代码, 10000为请求成功，其他为请求失败。", required = true, dataType = "int")
    private int code;

    @ApiModelProperty(value = "请求失败的msg")
    private String msg;

    @ApiModelProperty(value = "请求成功返回的数据")
    private T data;

    private Long stamp;

    public static ApiResult success() {
        return success("", "");
    }

    public static ApiResult success(Object data) {
        return success("", data);
    }

    public static ApiResult success(String message, Object data) {
        ApiResult result = new ApiResult();
        result.setCode(SUCCESS_CODE);
        result.setMsg(message);
        result.setStamp(System.currentTimeMillis());
        result.setData(data);
        return result;
    }

    public static ApiResult failed(String message) {
        return failed(COMMON_FAILED_CODE, message);
    }

    public static ApiResult failed(int code, String message) {
        ApiResult result = new ApiResult();
        result.setCode(code);
        result.setMsg(message);
        result.setStamp(System.currentTimeMillis());
        //result.setData("");
        return result;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getStamp() {
        return stamp;
    }

    public void setStamp(Long stamp) {
        this.stamp = stamp;
    }
}
