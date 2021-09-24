package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.GameGenre;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "game")
public class GameEntity implements Serializable {
    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "gameid")
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "game_gameid_seq")
    public long gameId;

    public String name;

    public String description;

    @Enumerated
    @Column(name = "gamegenreid")
    public GameGenre gameGenre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "gameplatform",
            joinColumns = { @JoinColumn(name = "gameid") },
            inverseJoinColumns = { @JoinColumn(name = "platformid") })
    public List<Platform> platforms;

    public String developer;

    public LocalDate release;

    @Column(name = "priceincents")
    public long price;
}
