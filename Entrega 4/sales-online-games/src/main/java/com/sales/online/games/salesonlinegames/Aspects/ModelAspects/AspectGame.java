package com.sales.online.games.salesonlinegames.Aspects.ModelAspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectGame {
    
    @Around("execution (* setName(name,..))")
    public void around(ProceedingJoinPoint joinPoint) {
        Object[] obj = joinPoint.getArgs();

        String name = (String) obj[0];

        if (name.isBlank() || name == null) {
            return;
        }

        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
