package com.sales.online.games.salesonlinegames.Presentation.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sales.online.games.salesonlinegames.Model.Support.Genders;

@Entity
@Table(name = "game")
public class Game implements Serializable {
    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "gameid")
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "game_gameid_seq")
    private long gameid;

    private String name;
    private String description;

    @Enumerated
    private Genders gamegenreid;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "gameplatform",
            joinColumns = { @JoinColumn(name = "gameid") },
            inverseJoinColumns = { @JoinColumn(name = "platformid") })
    private List<Platforms> platforms = new ArrayList<>();

    private String developer;
    private LocalDate release;

    private long priceincents;

    public Game (String name, String description, long priceincents, Genders gender, String developer, LocalDate release) {
        this.name = name;
        this.description = description;
        this.priceincents = priceincents;
        this.gamegenreid = gender;
        this.developer = developer;
        this.release = release;
    }

    public Game() {}

    public void setPlatforms(List<Platforms> platforms) {
        this.platforms = platforms;
    }

    public long getId() {
        return gameid;
    }

    public void setId(long gameid) {
        this.gameid = gameid;
    }

    public void setGenre(Genders genre) {
        this.gamegenreid = genre;
    }

    public Genders getGenre() {
        return gamegenreid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Genders getGender() {
        return gamegenreid;
    }

    public String getDeveloper() {
        return developer;
    }

    public LocalDate getRelease() {
        return release;
    }

    public Long getPrice() {
        return priceincents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGender(Genders gender) {
        this.gamegenreid = gender;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public void setPriceInCents(long priceincents) {
        this.priceincents = priceincents;
    }
}
