package com.sales.online.games.salesonlinegames.Presentation.Aspects;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    
    @Pointcut("execution(* *..Controller.*.getAll())")
    public void getAllPointcut(){}

    @Pointcut("execution(* *..Controller.*.*ById(..))")
    public void getByIdPointcut(){}

    @Pointcut("execution(* *..Controller.*.create*(..))")
    public void createPointcut(){}

    @Pointcut("execution(* *..Controller.*.update*(..))")
    public void updatePointcut(){}

    @Pointcut("execution(* *..Controller.*.delete*(..))")
    public void deletePointcut(){}

    @Pointcut("execution(* *..OrderController.getDailyRelatory())")
    public void dailyRelatoryPointcut(){}

    @Pointcut("execution(* *..OrderController.getWeeklySalesRelatory())")
    public void weeklyRelatoryPointcut(){}

    @Pointcut("execution(* *..OrderController.confirmOrder(..))")
    public void confirmOrderPointCut(){}

    
    @Around("getAllPointcut()")
    public Object getAllAdvice(ProceedingJoinPoint joinPoint) {

        Logger logger = LoggerFactory.getLogger(this.getClass());

        Object obj = null;

        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {}

        MethodSignature sig = (MethodSignature) joinPoint.getSignature();

        Method method = sig.getMethod();

        Class cl = method.getDeclaringClass();

        String description = "Consulta de todos os cadastros da classe ";

        switch (cl.getSimpleName()) {
            case "CustomerController":
                description += "Customer";
                break;
            case "GameController":
                description += "Game";
                break;
            case "OrderController":
                description += "Order";
                break;
            case "UserController":
                description += "User";
        }

        logger.debug(description);

        return obj;
    }
    

    @Around("getByIdPointcut()")
    public Object getByIdAdvice(ProceedingJoinPoint joinPoint) {

        Logger logger = LoggerFactory.getLogger(this.getClass());

        Object obj = null;

        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {}

        MethodSignature sig = (MethodSignature) joinPoint.getSignature();

        Method method = sig.getMethod();

        Class cl = method.getDeclaringClass();

        var args = joinPoint.getArgs();

        long id = (long) args[0];

        String description = "Consulta de objeto. id: " + id + " , classe ";

        switch (cl.getSimpleName()) {
            case "CustomerController":
                description += "Customer";
                break;
            case "GameController":
                description += "Game";
                break;
            case "OrderController":
                description += "Order";
                break;
            case "UserController":
                description += "User";
        }

        logger.debug(description);

        return obj;
    }

    @Around("createPointcut()")
    public Object createAdvice(ProceedingJoinPoint joinPoint) {
        
        Logger logger = LoggerFactory.getLogger(this.getClass());

        Object obj = null;

        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {}

        MethodSignature sig = (MethodSignature) joinPoint.getSignature();

        Method method = sig.getMethod();

        Class cl = method.getDeclaringClass();

        String description = "Cadastro de objeto da classe ";

        switch (cl.getSimpleName()) {
            case "CustomerController":
                description += "Customer";
                break;
            case "GameController":
                description += "Game";
                break;
            case "OrderController":
                description += "Order";
                break;
            case "UserController":
                description += "User";
        }

        logger.debug(description);

        return obj;
    }

    @Around("updatePointcut()")
    public Object updateAdvice(ProceedingJoinPoint joinPoint) {
        
        Logger logger = LoggerFactory.getLogger(this.getClass());

        Object obj = null;

        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {}

        MethodSignature sig = (MethodSignature) joinPoint.getSignature();

        Method method = sig.getMethod();

        Class cl = method.getDeclaringClass();

        var args = joinPoint.getArgs();

        long id = (long) args[0];

        String description = "Altera????o de objeto. id: " + id + " , classe ";

        switch (cl.getSimpleName()) {
            case "CustomerController":
                description += "Customer";
                break;
            case "GameController":
                description += "Game";
                break;
            case "OrderController":
                description += "Order";
                break;
            case "UserController":
                description += "User";
        }

        logger.debug(description);

        return obj;
    }

    @Around("deletePointcut()")
    public Object deleteAdvice(ProceedingJoinPoint joinPoint) {

        Logger logger = LoggerFactory.getLogger(this.getClass());

        Object obj = null;

        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {}

        MethodSignature sig = (MethodSignature) joinPoint.getSignature();

        Method method = sig.getMethod();

        Class cl = method.getDeclaringClass();

        var args = joinPoint.getArgs();

        long id = (long) args[0];

        String description = "Remo????o de objeto. id: " + id + " , classe ";

        switch (cl.getSimpleName()) {
            case "CustomerController":
                description += "Customer";
                break;
            case "GameController":
                description += "Game";
                break;
            case "OrderController":
                description += "Order";
                break;
            case "UserController":
                description += "User";
        }

        logger.debug(description);

        return obj;
    }

    
    @Around("dailyRelatoryPointcut()")
    public Object dailyRelatoryAdvice(ProceedingJoinPoint joinPoint) {

        Logger logger = LoggerFactory.getLogger(this.getClass());

        Object obj = null;

        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {}

        String description = "Relat??rio di??rio de vendas de jogos";

        logger.debug(description);

        return obj;
    }

    @Around("weeklyRelatoryPointcut()")
    public Object weeklyRelatoryAdvice(ProceedingJoinPoint joinPoint) {

        Logger logger = LoggerFactory.getLogger(this.getClass());

        Object obj = null;

        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {}

        String description = "Relat??rio semanal de vendas desenvolvedor, g??nero e plataforma";

        logger.debug(description);

        return obj;
    }

    
    @Around("confirmOrderPointCut()")
    public Object confirmOrderAdvice(ProceedingJoinPoint joinPoint) {

        Logger logger = LoggerFactory.getLogger(this.getClass());

        Object obj = null;

        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {}

        var args = joinPoint.getArgs();

        long id = (long) args[0];

        String description = "Confirma????o da compra de id " + id;

        logger.debug(description);

        return obj;
    }
    
}
