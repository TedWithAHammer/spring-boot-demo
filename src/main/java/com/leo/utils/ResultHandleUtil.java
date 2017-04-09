package com.leo.utils;

import com.leo.db.ResultCallback;

/**
 *
 */
public class ResultHandleUtil {
    /**
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> ResultCallback handleSuccess(T obj) {
        ResultCallback<T> result = new ResultCallback<T>();
        result.setCode(200);
        result.setMsg("success");
        result.setData(obj);
        return result;
    }

    /**
     * @param code
     * @param msg
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> ResultCallback handleError(int code, String msg, T obj) {
        ResultCallback<T> result = new ResultCallback<T>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }


}
