package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "gamegenre")
public class GameGenreEntity {
    public static final Long serialVersionUID = 1L;
    
    @Id
    @Column(name = "gamegenreid")
    public Long gamegenreid;

    @Column(name = "name")
    public String name;
}