package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customerordergame")
public class OrderGameEntity implements Serializable {
    public static final Long serialVersionUID = 1L;
    
    @Id
    @Column(name = "customerorderid")
    public long customerId;

    @Id
    @Column(name = "gameid")
    public long gameId;
}
