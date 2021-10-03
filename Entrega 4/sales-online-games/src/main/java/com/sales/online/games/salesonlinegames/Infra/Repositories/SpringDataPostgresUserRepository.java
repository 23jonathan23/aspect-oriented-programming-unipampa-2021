package com.sales.online.games.salesonlinegames.Infra.Repositories;

import java.util.Optional;

import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataPostgresUserRepository extends JpaRepository<UserEntity, Long>{
    @Query(value = "SELECT * FROM marketplaceuser WHERE username = ?1", nativeQuery = true)
    Optional<UserEntity> findByUsername(String username);
}