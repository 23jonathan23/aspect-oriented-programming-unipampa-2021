package com.sales.online.games.salesonlinegames.Domain.Core.Response;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.UserType;

import lombok.Data;

@Data
public class UserResponse {
    public long userId;

    public String username;

    public UserType userType;
    
    public long customerId;
}
