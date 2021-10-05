package com.sales.online.games.salesonlinegames.Infra.Repositories;

import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.GameEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataPostgresGameRepository extends JpaRepository<GameEntity, Long>{
    
}
