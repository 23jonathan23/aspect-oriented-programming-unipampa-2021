package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gameplatform")
public class GamePlatformEntity implements Serializable {

    public GamePlatformEntity(long gameId, long platformId) {
        this.gameId = gameId;
        this.platformId = platformId;
    }

    @Id
    @Column(name = "gameid")
    public long gameId;

    @Column(name = "platformid")
    @Id
    public long platformId;
}
