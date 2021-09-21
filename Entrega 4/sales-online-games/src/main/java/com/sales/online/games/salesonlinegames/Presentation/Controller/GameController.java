package com.sales.online.games.salesonlinegames.Presentation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sales.online.games.salesonlinegames.Presentation.Model.Game;
import com.sales.online.games.salesonlinegames.Presentation.Service.GameService;

@RestController
public class GameController {
    
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> selectGames() {
        return gameService.selectGames();
    }

    @GetMapping(value = "/{id}")
    public Game selectGame(@PathVariable long id) {
        return gameService.selectGame(id);
    }

    @PostMapping
    public void insertGame(@RequestBody Game game) {
        
        gameService.insertGame(game);
    }

    @PutMapping(value = "/{id}")
    public void updateGame(@PathVariable long id, @RequestBody Game game) {

        gameService.updateGame(id, game);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGame(@PathVariable long id) {

        gameService.deleteGame(id);
    }
}
