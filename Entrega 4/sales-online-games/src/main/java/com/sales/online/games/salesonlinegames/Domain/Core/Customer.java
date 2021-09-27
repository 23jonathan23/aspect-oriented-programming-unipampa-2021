package com.sales.online.games.salesonlinegames.Domain.Core;

import java.time.LocalDate;
import java.util.List;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.GameGenre;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;

public class Customer{
    private long customerId;
    private String name;
    private String email;
    private LocalDate birthDate;
    private List<Platform> platforms;
    private List<GameGenre> favoriteGenres;
    private Address address;

    public Customer(){}

    public Customer(String name, String email, LocalDate birthDate, Address address){
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
    }

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Platform> getPlatforms() {
        return this.platforms;
    }

    public List<GameGenre> getGendersPref() {
        return this.favoriteGenres;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void removePlatform(Platform platform) {
        if (platforms.contains(platform))
            platforms.remove(platform);
    }

    public void addPlatform(Platform platform) {
        if (!platforms.contains(platform))
            platforms.add(platform);
    }

    public void removeFavoriteGenres(GameGenre genre) {
        if (favoriteGenres.contains(genre))
            favoriteGenres.remove(genre);
    }

    public void addFavoriteGenres(GameGenre genre) {
        if (!favoriteGenres.contains(genre))
            favoriteGenres.add(genre);
    }
}