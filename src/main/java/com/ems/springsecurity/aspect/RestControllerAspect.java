package com.ems.springsecurity.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class RestControllerAspect {
    private Logger logger = null;

    @Before("execution(* com.ems.springsecurity.api.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger = Logger.getLogger(joinPoint.getTarget().getClass().getName());
        logger.info(joinPoint.getSignature().getName() + ": Executing");
    }

    @AfterReturning(value = "execution(* com.ems.springsecurity.api.*.*(..))",
            returning = "result")
    public void logOnReturning(JoinPoint joinPoint, ResponseEntity result) {
        logger = Logger.getLogger(joinPoint.getTarget().getClass().getName());
        Logger.getLogger(joinPoint.getTarget().getClass().getName());
        logger.info(joinPoint.getSignature().getName() + ": Execution successful with code " +
                result.getStatusCode());
    }

    //TODO: redesign the way controller handles the bad request and then use it
//    @AfterThrowing(value = "execution(* com.ems.springsecurity.api.*.*(..))",
//            throwing = "error")
//    public void logOnThrowing(JoinPoint joinPoint, Throwable error) {
//        logger = Logger.getLogger(joinPoint.getTarget().getClass().getName());
//        Logger.getLogger(joinPoint.getTarget().getClass().getName());
//        logger.severe(joinPoint.getSignature().getName() + ": Execution failed");
//        logger.severe(error.getMessage());
//    }
}
