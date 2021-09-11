package com.sales.online.games.salesonlinegames.Model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.sales.online.games.salesonlinegames.Model.Support.Platforms;

public class Game{

    private UUID id;

    private String name;
    private String description;
    private String gender;
    private List<Platforms> platforms;
    private String developer;
    private LocalDate release;
    private Double price;

    public Game (String name, String description, String gender, String developer, LocalDate release) {
        this.name = name;
        this.description = description;
        this.gender = gender;
        this.developer = developer;
        this.release = release;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getGender() {
        return gender;
    }

    public List<Platforms> getPlatforms() {
        return platforms;
    }

    public String getDeveloper() {
        return developer;
    }

    public LocalDate getRelease() {
        return release;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription() {
        this.description = description;
    }

    public void setGender() {
        this.gender = gender;
    }

    public boolean removePlatform(Platforms platform) {
        return platforms.remove(platform);
    }

    public boolean addPlatform(Platforms platform) {
        boolean contains = platforms.contains(platform);

        if (contains) {
            return false;
        }

        return platforms.remove(platform);
    }

    private void setDeveloper(String developer) {
        this.developer = developer;
    }

    private void setRelease(LocalDate release) {
        this.release = release;
    }

    private void setPrice(Double price) {
        this.price = price;
    }
}
