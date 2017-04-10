package com.leo.utils;

import com.leo.db.ResultCallback;
import com.leo.enums.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangliying on 2017/4/10.
 * Description:
 */
@ControllerAdvice
public class SpringExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultCallback handle(Exception ex) {
        return ResultHandleUtil.handleError(ResultEnum.SERVER_NOT_FOUND, null);
    }

}
