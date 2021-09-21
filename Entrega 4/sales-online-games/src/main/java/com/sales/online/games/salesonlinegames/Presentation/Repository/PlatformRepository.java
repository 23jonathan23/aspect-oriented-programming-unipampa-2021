package com.sales.online.games.salesonlinegames.Presentation.Repository;

import com.sales.online.games.salesonlinegames.Presentation.Model.Platforms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platforms, Long> {

}
