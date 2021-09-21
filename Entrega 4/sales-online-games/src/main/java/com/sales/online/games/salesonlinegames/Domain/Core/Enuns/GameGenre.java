package com.sales.online.games.salesonlinegames.Domain.Core.Enuns;

public enum GameGenre {
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

    public final int value = 1 + ordinal();
}