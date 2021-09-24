package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.GameGenre;

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

    public String developer;

    public LocalDate release;

    @Column(name = "priceincents")
    public long price;
}
