package com.example.authorization_service.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class HandlerMethodArgumentAspect {
    
    @Around("@annotation(HandlerMethodArgumentResolver)")
    public Object handlerArgument(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }
}


