package com.sales.online.games.salesonlinegames.Domain.Core.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.UserType;

public class CreateUserRequest {

    @NotBlank
    public String username;

    @NotBlank
    public String password;

    @NotNull
    public UserType userType;
    
    @NotNull
    public long customerId;
}
