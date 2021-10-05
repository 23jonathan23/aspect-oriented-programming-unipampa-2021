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

    public List<GameGenre> getFavoriteGenres() {
        return this.favoriteGenres;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public void setFavoriteGenres(List<GameGenre> genres) {
        favoriteGenres = genres;
    }
}