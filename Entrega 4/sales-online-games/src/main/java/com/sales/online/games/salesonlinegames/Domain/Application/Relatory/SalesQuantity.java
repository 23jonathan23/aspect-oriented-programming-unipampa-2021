package com.sales.online.games.salesonlinegames.Domain.Application.Relatory;

public class SalesQuantity {
    
    protected int sales;

    public int getSales() {
        return sales;
    }

    public void addQuantity(int quantity) {
        sales+= quantity;
    }
}
