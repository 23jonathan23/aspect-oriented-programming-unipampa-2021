package com.sales.online.games.salesonlinegames.Infra.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresRepository<T> extends JpaRepository<T, Long>{
    
}
