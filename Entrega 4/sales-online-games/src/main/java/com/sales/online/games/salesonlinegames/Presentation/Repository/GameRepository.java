package com.sales.online.games.salesonlinegames.Presentation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.online.games.salesonlinegames.Presentation.Model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
