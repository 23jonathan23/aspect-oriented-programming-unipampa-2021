package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
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
    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "customerid")
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "customer_customerid_seq")
    public long customerId;

    @Column(name = "name")
    public String name;

    @Column(name = "email")
    public String email;
    
    @Column(name = "birthdate")
    public LocalDate birthDate;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "addressid", referencedColumnName = "addressid")
    public AddressEntity address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customerfavoritegenre",
            joinColumns = { @JoinColumn(name = "customerid") },
            inverseJoinColumns = { @JoinColumn(name = "gamegenreid") })
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<GameGenreEntity> favoriteGenres;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customerplatform",
            joinColumns = { @JoinColumn(name = "customerid") },
            inverseJoinColumns = { @JoinColumn(name = "platformid") })
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<PlatformEntity> platforms;
}
