package com.sales.online.games.salesonlinegames.Presentation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.online.games.salesonlinegames.Presentation.Repository.GameRepository;
import com.sales.online.games.salesonlinegames.Presentation.Model.Game;

@Service
public class GameService {
    
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> selectGames() {
        return gameRepository.findAll();
    }

    public Game selectGame(long id) {
        Game game = gameRepository.getById(id);
        return game;
    }

    public void insertGame(Game game) {
        gameRepository.save(game);
    }

    public void updateGame(long id, Game game) {
        game.setId(id);

        gameRepository.save(game);
    }

    public void deleteGame(long id) {
        Game game = gameRepository.getById(id);

        gameRepository.delete(game);
    }
}
