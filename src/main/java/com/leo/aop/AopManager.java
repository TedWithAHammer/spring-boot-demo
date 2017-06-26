package com.leo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by wangliying on 2017/4/10.
 * Description:
 */
@Aspect
@Component
public class AopManager {
    private static Logger log = LoggerFactory.getLogger(AopManager.class.getSimpleName());

//    @Pointcut("execution(public * com.leo.controller.*.*(..))")
//    public void log() {
//
//    }
//
//    @Before("log()")
//    public void handleException(JoinPoint joinPoint) {
//        log.info(joinPoint.getSignature().toLongString());
//    }
}
