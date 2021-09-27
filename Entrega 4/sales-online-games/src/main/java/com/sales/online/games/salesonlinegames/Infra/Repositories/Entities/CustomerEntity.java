package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sales.online.games.salesonlinegames.Domain.Core.Address;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {

    @Id
    @Column(name = "customerid")
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "customer_customerid_seq")
    public long customerId;

    public String name;

    public String email;
    
    public LocalDate birthDate;

    @Column(name = "address")    
    public Address address;
    
}
