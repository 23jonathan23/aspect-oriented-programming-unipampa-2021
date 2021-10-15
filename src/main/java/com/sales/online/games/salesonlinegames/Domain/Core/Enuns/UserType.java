package com.sales.online.games.salesonlinegames.Domain.Core.Enuns;

public enum UserType {
    UNDEFINED,
    ADMIN,
    CUSTOMER,
    SALER,
    MANAGER;

    public final long value = ordinal();
}
