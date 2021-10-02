package com.sales.online.games.salesonlinegames.Domain.Core.Enuns;

public enum PaymentMethod {
    UNDEFINED,
    DEBIT, 
    CREDIT;

    public final long value = ordinal();
}
