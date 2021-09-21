package com.sales.online.games.salesonlinegames.Presentation.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gameplatform")
public class GamePlatform implements Serializable {
    public static final Long serialVersionUID = 1L;
    
    @Id
    @Column(name = "gameid")
    private long gameid;

    @Column(name = "platformid")
    @Id
    private long platformid;

    public GamePlatform(long gameid, long platformid) {
        this.gameid = gameid;
        this.platformid = platformid;
    }

    public void setGameId(long gameid) {
        this.gameid = gameid;
    }

    public void setPlatformId(long platformid) {
        this.platformid = platformid;
    }

    public long getGameId() {
        return gameid;
    }

    public long getPlatformId() {
        return platformid;
    }
}
