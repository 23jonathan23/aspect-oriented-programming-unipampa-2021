package com.sales.online.games.salesonlinegames.Domain.Core.Report;

public class SalesQuantity {
    
    protected int sales;

    public int getSales() {
        return sales;
    }

    public void addQuantity(int quantity) {
        sales+= quantity;
    }
}
