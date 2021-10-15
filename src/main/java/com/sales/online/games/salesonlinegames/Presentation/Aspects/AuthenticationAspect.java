package com.sales.online.games.salesonlinegames.Presentation.Aspects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sales.online.games.salesonlinegames.Domain.Application.AuthenticationService;

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
@Order(0)
@Configuration
public class AuthenticationAspect {
    @Autowired
    AuthenticationService authenticationService;

    private static final String HEADER_AUTHORIZATION = "Authorization";

    private static final int UNAUTHORIZED_CODE = HttpStatus.UNAUTHORIZED.value();
    
    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controller() {
    }

    @Around("controller()")
    public Object authenticationAround(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        String authToken = request.getHeader(HEADER_AUTHORIZATION);

        if(authToken == null) {
            response.sendError(UNAUTHORIZED_CODE);
            
            return null;
        }

        var canAuthenticate = authenticationService.validateAuthenticationToken(authToken);

        if(!canAuthenticate) {
            response.sendError(UNAUTHORIZED_CODE);
            
            return null;
        }

        return pjp.proceed();
    }
}
