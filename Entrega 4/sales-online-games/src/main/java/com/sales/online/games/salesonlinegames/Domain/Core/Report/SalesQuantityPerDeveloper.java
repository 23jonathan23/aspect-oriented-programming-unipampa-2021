package com.sales.online.games.salesonlinegames.Domain.Core.Report;

public class SalesQuantityPerDeveloper extends SalesQuantity {
    
    private String developer;
    
    public SalesQuantityPerDeveloper(String developer) {
        this.developer = developer;
        sales = 1;
    }

    public String getDeveloper() {
        return developer;
    }
}
