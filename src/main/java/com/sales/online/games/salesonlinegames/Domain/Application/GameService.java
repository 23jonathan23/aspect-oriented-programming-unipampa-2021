package com.sales.online.games.salesonlinegames.Domain.Application;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IGameRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.Game;

public class GameService {
    
    private final IGameRepository gameRepository;

    public GameService(final IGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAll() {
        return gameRepository.getAll();
    }

    public Game findById(long gameId) {
        Optional<Game> game = gameRepository.findGameById(gameId);

        if(game.isPresent())
            return game.get();

        return null;
    }

    public Game createGame(Game request) {
        request.setRelease(LocalDate.now());

        var gameInserted = gameRepository.insertGame(request);

        return gameRepository.findGameById(gameInserted.getGameId()).get();
    }

    public Game updateGame(long gameId, Game updatedGame) {
        Optional<Game> game = gameRepository.findGameById(gameId);
        
        if(game.isPresent())
            return gameRepository.updateGame(gameId, updatedGame);
        
        return null;
    }

    public OptionalLong deleteGame(long gameId) {
        Optional<Game> game = gameRepository.findGameById(gameId);
        
        if(game.isPresent()) {
            gameRepository.deleteGame(game.get());
            return OptionalLong.of(gameId);
        }
        
        return OptionalLong.empty();
    }
}
