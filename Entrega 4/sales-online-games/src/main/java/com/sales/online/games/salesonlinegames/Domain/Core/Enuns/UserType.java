package com.sales.online.games.salesonlinegames.Domain.Core.Enuns;

public enum UserType {
    ADMIN,
    CUSTOMER,
    SALER,
    MANAGER;

    public final int value = 1 + ordinal();
}
