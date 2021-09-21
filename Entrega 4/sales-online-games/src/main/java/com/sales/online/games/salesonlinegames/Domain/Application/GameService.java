package com.sales.online.games.salesonlinegames.Domain.Application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IGameRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.Game;
import com.sales.online.games.salesonlinegames.Infra.Repositories.GamePlatformRepository;

@Service
public class GameService {
    
    private final IGameRepository gameRepository;

    private final GamePlatformRepository gamePlatformRepository;

    @Autowired
    public GameService(final IGameRepository gameRepository, final GamePlatformRepository gamePlatformRepository) {
        this.gameRepository = gameRepository;
        this.gamePlatformRepository = gamePlatformRepository;
    }

    public Game findById(long gameId) {    
        Optional<Game> game = gameRepository.findGameById(gameId);

        if(game.isPresent())
            return game.get();

        return null;
    }

    public Game createGame(Game request) {
        var game = gameRepository.insertGame(request);

        for(var platform : game.getPlatforms())
            gamePlatformRepository.insertGamePlataform(game.getGameId(), platform);

        return game;
    }

    public Game updateGame(long gameId, Game updatedGame) {
        Optional<Game> game = gameRepository.findGameById(gameId);
        
        if(game.isPresent())
            return gameRepository.updateGame(gameId, updatedGame);
        
        return null;
    }

    public void deleteGame(long gameId) {
        Optional<Game> game = gameRepository.findGameById(gameId);
        
        if(game.isPresent())
            gameRepository.deleteGame(game.get());
    }
}
