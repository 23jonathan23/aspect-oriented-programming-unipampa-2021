package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "platform")
public class PlatformEntity {
    public static final Long serialVersionUID = 1L;
    
    @Id
    @Column(name = "platformid")
    public Long platformid;

    @Column(name = "name")
    public String name;
}