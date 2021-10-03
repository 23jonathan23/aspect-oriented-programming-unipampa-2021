package com.sales.online.games.salesonlinegames.Presentation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.sales.online.games.salesonlinegames.Domain.Application.AuthenticationService;
import com.sales.online.games.salesonlinegames.Domain.Core.Request.AuthenticationRequest;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/generateToken")
    public ResponseEntity<Object> getAuthenticationToken(@RequestBody @Valid AuthenticationRequest request) {
        var authenticationResponse = authenticationService.getAuthenticationToken(request);

        return authenticationResponse != null
            ? ResponseEntity.status(HttpStatus.OK).body(authenticationResponse)
            : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username or password is incorrect.");
    }
}
