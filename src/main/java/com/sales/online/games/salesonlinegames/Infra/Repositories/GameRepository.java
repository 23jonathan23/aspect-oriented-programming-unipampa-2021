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
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.GameEntity;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.PlatformEntity;

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
        var gameToInsert = modelMapper.map(game, GameEntity.class);
        
        var platformsEntity = new ArrayList<PlatformEntity>();

        for(var platform : game.getPlatforms()) {
            var platformEntity = new PlatformEntity();
            platformEntity.platformid = platform.value;
            
            platformsEntity.add(platformEntity);
        }

        gameToInsert.platforms = platformsEntity;

        GameEntity gameEntity = repository.save(gameToInsert);
        
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
        
        if (gameEntity.isPresent()) {
            var game = modelMapper.map(gameEntity.get(), Game.class);
            game.setPlatforms(mapPlatformEntityToPlatformEnum(gameEntity.get().platforms));
            
            return Optional.of(game);
        }
        
        return Optional.empty();
    }

    public List<Game> getAll() {
        var gamesEntity = repository.findAll();

        var response = new ArrayList<Game>();

        for(var gameEntity : gamesEntity) {
            var platforms = mapPlatformEntityToPlatformEnum(gameEntity.platforms);
            
            var game = modelMapper.map(gameEntity, Game.class);
            game.setPlatforms(platforms);
            
            response.add(game);
        }

        return response;
    }

    private List<Platform> mapPlatformEntityToPlatformEnum(List<PlatformEntity> platformsEntity) {
        var platforms = new ArrayList<Platform>();

        for(var platformEntity : platformsEntity) 
            platforms.add(Platform.values()[platformEntity.platformid.intValue()]);
        
        return platforms;
    }
}
