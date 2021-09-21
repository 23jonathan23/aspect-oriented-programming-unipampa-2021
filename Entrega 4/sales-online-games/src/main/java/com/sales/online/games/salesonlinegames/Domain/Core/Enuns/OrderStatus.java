package com.sales.online.games.salesonlinegames.Domain.Core.Enuns;

public enum OrderStatus {
    PROCESSING,
    FINISHED;

    public final int value = 1 + ordinal();
}
