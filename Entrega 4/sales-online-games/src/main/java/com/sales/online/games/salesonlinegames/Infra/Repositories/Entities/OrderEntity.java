package com.sales.online.games.salesonlinegames.Infra.Repositories.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.OrderStatus;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.PaymentMethod;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "customerorder")
public class OrderEntity implements Serializable {
    public static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "customerorderid")
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "customerorder_customerorderid_seq")
    public long orderId;

    @Enumerated
    @Column(name = "paymentmethodid")
    public PaymentMethod paymentMethod;

    @Column(name = "installment")
    public int installment;

    @Column(name = "purchasedate")
    public LocalDate purchaseDate;

    @Column(name = "coupon")
    public String coupon;

    @Column(name = "cardholdername")
    public String cardHolderName;

    @Column(name = "cardnumber")
    public String cardNumber;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "orderstatusid")
    public OrderStatus status;

    @Column(name = "customerid")
    public long customerId;

    @Column(name = "amountincents")
    public long amount;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customerordergame",
            joinColumns = { @JoinColumn(name = "customerorderid") },
            inverseJoinColumns = { @JoinColumn(name = "gameid") })
    public List<GameEntity> games;
}
