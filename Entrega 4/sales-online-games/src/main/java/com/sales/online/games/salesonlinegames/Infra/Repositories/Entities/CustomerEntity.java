package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {

    @Id
    @Column(name = "customerid")
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "customer_customerid_seq")
    public long customerId;

    @Column(name = "name")
    public String name;

    @Column(name = "name")
    public String email;
    
    @Column(name = "birthdate")
    public LocalDate birthDate;

//Corrigir relação
//     @OneToOne(fetch = FetchType.LAZY)
//     @JoinTable(name = "address",
//             joinColumns = { @JoinColumn(name = "custumerid", referencedColumnName = "custumerid") },
//             inverseJoinColumns = { @JoinColumn(name = "addressid", referencedColumnName = "addressid") })
//     @OnDelete(action = OnDeleteAction.CASCADE)
//     public AddressEntity address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customerfavoritegenre",
            joinColumns = { @JoinColumn(name = "customerid") },
            inverseJoinColumns = { @JoinColumn(name = "gamegenreid") })
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<GameGenreEntity> favoriteGenres;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "gameplatform",
            joinColumns = { @JoinColumn(name = "gameid") },
            inverseJoinColumns = { @JoinColumn(name = "platformid") })
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<PlatformEntity> platforms;
}
