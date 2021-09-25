package com.sales.online.games.salesonlinegames.Domain.Core.Enuns;


public enum Platform {
    UNDEFINED,
    WINDOWS, 
    MAC, 
    LINUX, 
    ANDROID, 
    IOS, 
    XBOXONE, 
    PLAYSTATION4, 
    NINTENDO_SWITH;

    public final long value = ordinal();
}