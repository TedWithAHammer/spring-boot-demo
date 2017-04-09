package com.leo.db;

/**
 * Created by wangliying on 2017/4/9.
 * Description:
 */
public class ResultCallback<T> {
    public int Code;
    private String msg;
    private T data;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
