package com.sales.online.games.salesonlinegames.Domain.Core.Response;

import lombok.Data;

@Data
public class AuthenticationResponse {
    public String token;

    public long expiredAt;
}
