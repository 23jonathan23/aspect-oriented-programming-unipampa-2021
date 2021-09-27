package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "user_userid_seq")
    public long userId;

    public String username;

    public String password;    
}
