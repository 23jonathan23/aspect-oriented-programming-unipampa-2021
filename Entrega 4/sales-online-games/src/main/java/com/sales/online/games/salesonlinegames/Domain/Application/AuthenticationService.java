package com.sales.online.games.salesonlinegames.Domain.Application;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IUserRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.User;
import com.sales.online.games.salesonlinegames.Domain.Core.Request.AuthenticationRequest;
import com.sales.online.games.salesonlinegames.Domain.Core.Response.AuthenticationResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationService {
    @Autowired
    PasswordEncoder encoder;

    private final IUserRepository userRepository;

    private static final int TOKEN_EXPIRATION = 86400000;

    private static final String TOKEN_PASSWORD = "4e36e84c-0301-4977-ba8a-b2bb769bff99";

    private static final String ATTRIBUTE_PREFIX = "Bearer ";

    private static final String AUDIENCE = "marketplacegame.com.br";

    private static final String CLAIN_PERMISSION_NAME = "Permission";

    public AuthenticationService(final IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthenticationResponse getAuthenticationToken(AuthenticationRequest request) {
        var user = userRepository.findUserByUsername(request.getUsername());
        
        if (user.isEmpty())
            return null;

        var isValidPassword = isMatchesPassword(request.getPassword(), user.get().getPassword());
       
        if(isValidPassword)
            return generateToken(user.get());
        
        return null;
    }

    public boolean validateAuthenticationToken(String authToken) {
        if(!authToken.startsWith(ATTRIBUTE_PREFIX))
            return false;

        authToken = getTokenWithoutBearerPrefix(authToken);

        var audience = JWT.require(Algorithm.HMAC512(TOKEN_PASSWORD))
            .build()
            .verify(authToken)
            .getAudience();

        return audience != null && audience.contains(AUDIENCE);
    }

    public String getTokenPermission(String authToken) {
        authToken = getTokenWithoutBearerPrefix(authToken);

        var clain = JWT.require(Algorithm.HMAC512(TOKEN_PASSWORD))
            .build()
            .verify(authToken)
            .getClaim(CLAIN_PERMISSION_NAME);

        return clain.asString();
    }

    public String getTokenSubject(String authToken) {
        authToken = getTokenWithoutBearerPrefix(authToken);

        var subject = JWT.require(Algorithm.HMAC512(TOKEN_PASSWORD))
            .build()
            .verify(authToken)
            .getSubject();

        return subject;
    }

    private boolean isMatchesPassword(String informedPassword, String userPassword) {
        return encoder.matches(informedPassword, userPassword);
    }

    private AuthenticationResponse generateToken(User user) {
        var expiredAt = new Date(System.currentTimeMillis() + TOKEN_EXPIRATION);
        
        var token = JWT.create()
            .withSubject(user.getUsername())
            .withAudience(AUDIENCE)
            .withClaim(CLAIN_PERMISSION_NAME, user.getUserType().toString())
            .withExpiresAt(expiredAt)
            .sign(Algorithm.HMAC512(TOKEN_PASSWORD));

        var authResponse = new AuthenticationResponse();

        authResponse.token = token;
        authResponse.expiredAt = expiredAt.getTime();

        return authResponse;
    }

    private String getTokenWithoutBearerPrefix(String authToken) {
        return authToken.replace(ATTRIBUTE_PREFIX, "").replace(" ", "");
    }
}
