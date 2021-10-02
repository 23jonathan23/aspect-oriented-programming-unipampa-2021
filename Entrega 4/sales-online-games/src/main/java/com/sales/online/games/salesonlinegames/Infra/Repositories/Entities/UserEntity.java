package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.UserType;

import lombok.Data;

@Data
@Entity
@Table(name = "marketplaceuser")
public class UserEntity implements Serializable {

    @Id
    @Column(name = "marketplaceuserid")
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "marketplaceuser_marketplaceuserid_seq")
    public long userId;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "usertypeid")
    @Enumerated
    public UserType userType;

    @Column(name = "custumerid")
    public long custumerId;
}
