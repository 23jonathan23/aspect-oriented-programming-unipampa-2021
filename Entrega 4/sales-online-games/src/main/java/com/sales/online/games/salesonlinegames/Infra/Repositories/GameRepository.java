package com.sales.online.games.salesonlinegames.Infra.Repositories;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IGameRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.Game;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.GameEntity;

@Repository
public class GameRepository implements IGameRepository {

    private final PostgresRepository<GameEntity> repository;

    public GameRepository(final PostgresRepository<GameEntity> repository) {
        this.repository = repository;
    }

    @Autowired
    ModelMapper modelMapper;
    
    public Game insertGame(Game game) {
        GameEntity gameEntity = repository.save(modelMapper.map(game, GameEntity.class));
        
        return modelMapper.map(gameEntity, Game.class);
    }

    public Game updateGame(long gameId, Game game) {
        var gameEntity = modelMapper.map(game, GameEntity.class);

        gameEntity.setGameId(gameId);

        repository.save(gameEntity);
        
        return modelMapper.map(gameEntity, Game.class);
    }

    public void deleteGame(Game game) {
        repository.delete(modelMapper.map(game, GameEntity.class));
    }

    public Optional<Game> findGameById(long gameId) {
        Optional<GameEntity> gameEntity = repository.findById(gameId);
        
        if (gameEntity.isPresent())
            return Optional.of(modelMapper.map(gameEntity.get(), Game.class));
        else
            return Optional.empty();
    }
}
