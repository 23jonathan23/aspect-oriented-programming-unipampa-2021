package com.sales.online.games.salesonlinegames.Presentation.Aspects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sales.online.games.salesonlinegames.Domain.Application.AuthenticationService;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.UserType;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Order(1)
@Configuration
public class AuthorizationAspect {
    @Autowired
    AuthenticationService authenticationService;

    private static final String HEADER_AUTHORIZATION = "Authorization";

    private static final int FORBIDDEN_CODE = HttpStatus.FORBIDDEN.value();

    @Pointcut("execution(* com.sales.online.games.salesonlinegames.Presentation.Controller.UserController.*(..))")
    public void userController() {
    }

    @Pointcut("execution(* com.sales.online.games.salesonlinegames.Presentation.Controller.GameController.*(..))")
    public void gameController() {
    }

    @Pointcut("execution(* com.sales.online.games.salesonlinegames.Presentation.Controller.CustomerController.*(..))")
    public void customerController() {
    }

    @Pointcut("execution(* com.sales.online.games.salesonlinegames.Presentation.Controller.OrderController.*(..))")
    public void orderController() {
    }

    @Pointcut("execution(* com.sales.online.games.salesonlinegames.Presentation.Controller.OrderController.createOrder(..))")
    public void createOrderEndpoint() {
    }

    @Pointcut("execution(* com.sales.online.games.salesonlinegames.Presentation.Controller.OrderController.confirmOrder(..))")
    public void confirmOrderEndpoint() {
    }

    @Around("userController()")
    public Object userControllerAuthorizationAround(ProceedingJoinPoint pjp) throws Throwable {
        var permissions = Arrays.asList(UserType.ADMIN, UserType.MANAGER);

        return checkTokenContainsPermission(pjp, permissions);
    }

    @Around("gameController()")
    public Object gameControllerAuthorizationAround(ProceedingJoinPoint pjp) throws Throwable {
        var permissions = Arrays.asList(UserType.ADMIN, UserType.MANAGER);

        return checkTokenContainsPermission(pjp, permissions);
    }

    @Around("customerController()")
    public Object customerControllerAuthorizationAround(ProceedingJoinPoint pjp) throws Throwable {
        var permissions = Arrays.asList(UserType.ADMIN, UserType.MANAGER, UserType.SALER);

        return checkTokenContainsPermission(pjp, permissions);
    }

    @Around("orderController() && !createOrderEndpoint() && !confirmOrderEndpoint()")
    public Object orderControllerAuthorizationAround(ProceedingJoinPoint pjp) throws Throwable {
        var permissions = Arrays.asList(UserType.ADMIN, UserType.MANAGER);

        return checkTokenContainsPermission(pjp, permissions);
    }

    @Around("createOrderEndpoint()")
    public Object createOrderEndpointAuthorizationAround(ProceedingJoinPoint pjp) throws Throwable {
        var permissions = Arrays.asList(UserType.ADMIN, UserType.MANAGER, UserType.CUSTOMER);

        return checkTokenContainsPermission(pjp, permissions);
    }

    @Around("confirmOrderEndpoint()")
    public Object confirmOrderEndpointAuthorizationAround(ProceedingJoinPoint pjp) throws Throwable {
        var permissions = Arrays.asList(UserType.ADMIN, UserType.MANAGER, UserType.SALER);

        return checkTokenContainsPermission(pjp, permissions);
    }

    private Object checkTokenContainsPermission(ProceedingJoinPoint pjp, List<UserType> permissions) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        String authToken = request.getHeader(HEADER_AUTHORIZATION);

        var permission = authenticationService.getTokenPermission(authToken);

        if(permission == null) {
            response.sendError(FORBIDDEN_CODE);
            
            return null;
        }

        var userType = UserType.valueOf(permission);

        if(!permissions.contains(userType)) {
            response.sendError(FORBIDDEN_CODE);
            
            return null;
        }

        return pjp.proceed();
    }
}
