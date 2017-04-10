package com.leo.enums;

/**
 * Created by wangliying on 2017/4/10.
 * Description:
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1, "unknow error"),
    SUCCESS(200, "success"),
    SERVER_NOT_FOUND(404, "server not response");


    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private int code;
    private String msg;
}
