package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;

import lombok.Data;

@Data
@Entity
@Table(name = "gameplatform")
public class GamePlatformEntity implements Serializable {
    public static final Long serialVersionUID = 1L;
    
    @Id
    @Column(name = "gameid")
    public long gameId;

    @Id
    @Enumerated
    @Column(name = "platformid")
    public Platform platform;
}
