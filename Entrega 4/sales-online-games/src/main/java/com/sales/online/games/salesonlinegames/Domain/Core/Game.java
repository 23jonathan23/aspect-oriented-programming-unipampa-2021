package com.sales.online.games.salesonlinegames.Domain.Core;

import java.time.LocalDate;
import java.util.List;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.GameGenre;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;

public class Game{
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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public GameGenre getGender() {
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

    public void setGender(GameGenre gameGenre) {
        this.gameGenre = gameGenre;
    }

    public void removePlatform(Platform platform) {
        if (platforms.contains(platform))
            platforms.remove(platform);
    }

    public void addPlatform(Platform platform) {
        if (!platforms.contains(platform))
                platforms.add(platform);
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
