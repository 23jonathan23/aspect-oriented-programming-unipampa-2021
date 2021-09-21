package com.sales.online.games.salesonlinegames.Infra.Repositories;

import org.springframework.stereotype.Repository;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IGamePlatformRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.GamePlatformEntity;

@Repository
public class GamePlatformRepository implements IGamePlatformRepository {

    private final PostgresRepository<GamePlatformEntity> repository;

    public GamePlatformRepository(final PostgresRepository<GamePlatformEntity> repository) {
        this.repository = repository;
    }
    
    public void insertGamePlataform(long gameId, Platform platform) {
        var gamePlataformEntity = new GamePlatformEntity (gameId, platform.value);

        repository.save(gamePlataformEntity);
    }

    public void deleteGamePlataform(long gameId, Platform platform) {
        var gamePlataformEntity = new GamePlatformEntity (gameId, platform.value);

        repository.delete(gamePlataformEntity);
    }
}
