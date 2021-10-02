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
@Table(name = "address")
public class AddressEntity implements Serializable {

    @Id
    @Column(name = "addressid")
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "address_addressid_seq")
    public long addressId;

    @Column(name = "publicplace")
    private String publicPlace;

    @Column(name = "city")
    private String city;

    @Column(name = "federativeunit")
    private String federativeUnit;

    @Column(name = "zipcode")
    private String zipCode;

    @Column(name = "customerid")
    public long customerId;
}
