package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.GameGenre;

import lombok.Data;

@Data
@Entity
@Table(name = "customerfavoritegenre")
public class CustomerFavoriteGenreEntity implements Serializable {
    public static final Long serialVersionUID = 1L;
    
    @Id
    @Column(name = "customerid")
    public long customerId;

    @Id
    @Enumerated
    @Column(name = "gamegenreid")
    public GameGenre gameGenreId;
}
