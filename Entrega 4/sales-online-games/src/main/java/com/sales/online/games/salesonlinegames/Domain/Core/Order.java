package com.sales.online.games.salesonlinegames.Domain.Core;

import java.time.LocalDate;
import java.util.List;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.OrderStatus;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.PaymentMethod;

public class Order {
    private List<Game> games;
    private Card card;
    private PaymentMethod paymentMethod;
    private int installment;
    private LocalDate purchaseDate;
    private String coupon;
    private OrderStatus status;
    private long customerId;

    Order(Card creditCard, PaymentMethod paymentMethod, int installment, LocalDate purchaseDate, OrderStatus status){
        this.card = creditCard;
        this.installment = installment;
        this.paymentMethod = paymentMethod;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }

    public List<Game> getGames() {
        return this.games;
    }

    public boolean removeGames(Game game) {
        return games.remove(game);
    }

    public void addGames(Game game) {
        if (games.contains(game))
            games.add(game);
    }

    public Card getCreditCard() {
        return this.card;
    }

    public void setCreditCard(Card creditCard) {
        this.card = creditCard;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getInstallment() {
        return this.installment;
    }

    public void setInstallment(int installment) {
        this.installment = installment;
    }

    public LocalDate getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getCoupon() {
        return this.coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
