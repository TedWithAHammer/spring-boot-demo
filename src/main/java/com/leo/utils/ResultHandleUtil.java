package com.leo.utils;

import com.leo.domain.ResultCallback;
import com.leo.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class ResultHandleUtil {
    private static Logger logger = LoggerFactory.getLogger(ResultHandleUtil.class.getSimpleName());

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
        logger.info(result.toString());
        return result;
    }


    public static <T> ResultCallback handleError(ResultEnum _enum, T obj) {
        ResultCallback<T> result = new ResultCallback<T>();
        result.setCode(_enum.getCode());
        result.setMsg(_enum.getMsg());
        result.setData(obj);
        logger.info(result.toString());
        return result;
    }


}
