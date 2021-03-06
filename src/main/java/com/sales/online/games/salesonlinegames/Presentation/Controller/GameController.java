package com.sales.online.games.salesonlinegames.Presentation.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import com.sales.online.games.salesonlinegames.Domain.Application.GameService;
import com.sales.online.games.salesonlinegames.Domain.Core.Game;
import com.sales.online.games.salesonlinegames.Domain.Core.Request.CreateGameRequest;

@Controller
@RequestMapping("game")
public class GameController {
    
    @Autowired
    GameService gameService;

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        var response = gameService.getAll();

        return new ResponseEntity<>(response ,HttpStatus.OK);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Object> getGameById(@PathVariable long gameId) {
        var response = gameService.findById(gameId);

        return response != null
            ? new ResponseEntity<>(response ,HttpStatus.OK)
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found.");
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody @Valid CreateGameRequest request) {
        var game = new Game();
        
        BeanUtils.copyProperties(request, game);

        return new ResponseEntity<>(gameService.createGame(game), HttpStatus.CREATED);
    }

    @PutMapping("/{gameId}")
    public ResponseEntity<Object> updateGame(@PathVariable long gameId, @RequestBody Game request) {
        var response = gameService.updateGame(gameId, request);

        return response != null
            ? new ResponseEntity<>(response ,HttpStatus.OK)
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found.");   
    }

    @DeleteMapping("/{gameId}")
    public ResponseEntity<Object> deleteGame(@PathVariable long gameId) {
        var response = gameService.deleteGame(gameId);

        return response.isPresent()
            ? ResponseEntity.status(HttpStatus.OK).body("")
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found.");
    }
}
