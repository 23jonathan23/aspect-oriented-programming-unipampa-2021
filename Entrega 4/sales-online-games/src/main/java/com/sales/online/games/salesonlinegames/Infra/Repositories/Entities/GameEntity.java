package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.GameGenre;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "game")
public class GameEntity implements Serializable {
    @Id
    @Column(name = "gameid")
    public long gameId;

    public String name;

    public String description;

    @Enumerated
    public GameGenre gameGenreId;

    public String developer;

    public LocalDate release;

    public long priceInCents;
}
