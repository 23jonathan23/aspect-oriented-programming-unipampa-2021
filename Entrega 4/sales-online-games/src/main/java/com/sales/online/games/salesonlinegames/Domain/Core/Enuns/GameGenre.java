package com.sales.online.games.salesonlinegames.Domain.Core.Enuns;

public enum GameGenre {
    UNDEFINED,
    MOBA,
	FPS,
	MMO,
	RPG,
	SANDBOX,
    ACTION, 
    ADVENTURE, 
    ROLEPLAYING, 
    STRATEGY, 
    SIMULATION, 
    SPORTS, 
    RACING;

    public final long value = ordinal();
}