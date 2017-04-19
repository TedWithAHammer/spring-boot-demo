package com.leo.utils;

import com.leo.domain.ResultCallback;
import com.leo.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by wangliying on 2017/4/10.
 * Description:
 */
@ControllerAdvice
public class SpringExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(SpringExceptionHandler.class.getSimpleName());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultCallback handle(Exception ex) {
        logger.error(ex.getMessage());
        return ResultHandleUtil.handleError(ResultEnum.SERVER_NOT_FOUND, null);
    }

}
