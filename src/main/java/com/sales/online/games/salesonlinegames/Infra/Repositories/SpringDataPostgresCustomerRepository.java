package com.sales.online.games.salesonlinegames.Infra.Repositories;

import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.CustomerEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataPostgresCustomerRepository extends JpaRepository<CustomerEntity, Long>{
    
}