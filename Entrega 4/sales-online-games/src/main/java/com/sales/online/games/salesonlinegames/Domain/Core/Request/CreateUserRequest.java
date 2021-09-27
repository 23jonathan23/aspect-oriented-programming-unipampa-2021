package com.sales.online.games.salesonlinegames.Domain.Core.Request;

import javax.validation.constraints.NotBlank;

public class CreateUserRequest {

    @NotBlank
    public String username;

    @NotBlank
    public String password;
    
}
