package com.sales.online.games.salesonlinegames.Domain.Core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.GameGenre;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;

public class Game{
    private long gameId;
    private String name;
    private String description;
    private GameGenre gameGenre;
    private List<Platform> platforms;
    private String developer;
    private LocalDate release;
    private long price;

    public Game() {}

    public Game (String name, String description, GameGenre gameGenre, String developer, LocalDate release) {
        this.name = name;
        this.description = description;
        this.gameGenre = gameGenre;
        this.developer = developer;
        this.release = release;
    }

    public long getGameId() {
        return this.gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public GameGenre getGameGenre() {
        return gameGenre;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public String getDeveloper() {
        return developer;
    }

    public LocalDate getRelease() {
        return release;
    }

    public long getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGameGenre(GameGenre gameGenre) {
        this.gameGenre = gameGenre;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
