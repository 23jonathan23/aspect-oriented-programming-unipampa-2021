package com.sales.online.games.salesonlinegames.Domain.Application.Ports;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;

public interface IGamePlatformRepository {
    void insertGamePlataform(long gameId, Platform platform);

    void deleteGamePlataform(long gameId, Platform platform);
}
