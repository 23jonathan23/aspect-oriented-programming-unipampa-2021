package com.sales.online.games.salesonlinegames.Domain.Core.Request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AuthenticationRequest {
    @NotBlank
    public String username;

    @NotBlank
    public String password;
}
