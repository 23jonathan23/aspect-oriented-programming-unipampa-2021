package com.sales.online.games.salesonlinegames.Domain.Core.Enuns;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "platform")
public enum Platform {
    WINDOWS, 
    MAC, 
    LINUX, 
    ANDROID, 
    IOS, 
    XBOXONE, 
    PLAYSTATION4, 
    NINTENDO_SWITH;

    @Id
    public final long value = 1 + this.ordinal();
}