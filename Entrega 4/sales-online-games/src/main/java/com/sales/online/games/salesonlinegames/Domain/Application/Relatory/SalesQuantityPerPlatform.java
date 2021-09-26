package com.sales.online.games.salesonlinegames.Domain.Application.Relatory;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;

public class SalesQuantityPerPlatform extends SalesQuantity {
    
    private Platform platform;

    public SalesQuantityPerPlatform(Platform platform) {
        this.platform = platform;
        sales = 1;
    }

    public Platform getPlatform() {
        return platform;
    }
}
