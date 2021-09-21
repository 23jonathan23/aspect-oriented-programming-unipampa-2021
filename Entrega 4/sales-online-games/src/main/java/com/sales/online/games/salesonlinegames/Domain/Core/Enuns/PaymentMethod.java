package com.sales.online.games.salesonlinegames.Domain.Core.Enuns;

public enum PaymentMethod {
    DEBIT, 
    CREDIT;

    public final int value = 1 + ordinal();
}
