package com.example.AOP.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut (value = "@annotation(Logs)")
    public void callLoggingAround () {}
    @Around(value = "callLoggingAround")
    public Object loggingAround (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
      return proceedingJoinPoint.proceed();
    }
}
