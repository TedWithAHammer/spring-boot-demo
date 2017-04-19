package com.leo.domain;

/**
 * Created by wangliying on 2017/4/9.
 * Description:
 */
public class ResultCallback<T> {
    public int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "code:" + code + "\nmsg:" + msg + "\ndata:" + (data == null ? "null" : data.toString());
    }
}
