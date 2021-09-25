package com.sales.online.games.salesonlinegames.Domain.Core.Enuns;

public enum OrderStatus {
    UNDEFINED,
    PROCESSING,
    FINISHED;

    public final int value = ordinal();
}
