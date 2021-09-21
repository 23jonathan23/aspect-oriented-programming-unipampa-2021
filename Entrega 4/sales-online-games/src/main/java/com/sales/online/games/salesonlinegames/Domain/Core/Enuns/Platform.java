package com.sales.online.games.salesonlinegames.Domain.Core.Enuns;

public enum Platform {
    WINDOWS, 
    MAC, 
    LINUX, 
    ANDROID, 
    IOS, 
    XBOXONE, 
    PLAYSTATION4, 
    NINTENDO_SWITH;

    public final int value = 1 + ordinal();
}