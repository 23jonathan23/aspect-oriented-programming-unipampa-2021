package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class AddressEntity implements Serializable {
    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "addressid")
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "address_addressid_seq")
    public long addressId;

    @Column(name = "publicplace")
    public String publicPlace;

    @Column(name = "city")
    public String city;

    @Column(name = "federativeunit")
    public String federativeUnit;

    @Column(name = "zipcode")
    public String zipCode;
}
