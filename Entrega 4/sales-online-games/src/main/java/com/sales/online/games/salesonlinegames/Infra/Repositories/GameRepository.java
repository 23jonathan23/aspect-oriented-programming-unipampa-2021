package com.sales.online.games.salesonlinegames.Infra.Repositories;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IGameRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.Game;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.GameEntity;

@Component
@Primary
public class GameRepository implements IGameRepository {

    private final SpringDataPostgresGameRepository repository;

    public GameRepository(final SpringDataPostgresGameRepository repository) {
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

    public List<Game> getAll() {
        var games = repository.findAll();

        var response = new ArrayList<Game>();

        for(var game : games)
            response.add(modelMapper.map(game, Game.class));

        return response;
    }
}
