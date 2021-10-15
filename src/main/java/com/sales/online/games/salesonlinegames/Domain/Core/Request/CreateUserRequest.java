package com.sales.online.games.salesonlinegames.Domain.Core.Request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.UserType;

import lombok.Data;

@Data
public class CreateUserRequest {

    @NotBlank
    public String username;

    @NotBlank
    public String password;

    @NotNull
    public UserType userType;
    
    @DecimalMin(value = "0", inclusive = false)
    public long customerId;
}
