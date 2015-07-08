package com.hztech.framedemo.web.bean;

/**
 * Created by allan on 2015/7/8.
 */
public class ApiResult<T> {
    private int resultCode;
    private String msg;
    private T responseData;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResponseData() {
        return responseData;
    }

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }
}
