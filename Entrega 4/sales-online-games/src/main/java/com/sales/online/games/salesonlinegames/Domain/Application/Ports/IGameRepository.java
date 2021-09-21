package com.sales.online.games.salesonlinegames.Domain.Application.Ports;

import com.sales.online.games.salesonlinegames.Domain.Core.Game;

import java.util.Optional;

public interface IGameRepository {
    Game insertGame(Game game);

    Game updateGame(long gameId, Game game);

    void deleteGame(Game game);

    Optional<Game> findGameById(long gameId);
}
