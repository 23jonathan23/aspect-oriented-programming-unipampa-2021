package com.sales.online.games.salesonlinegames.Domain.Core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.OrderStatus;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.PaymentMethod;

public class Order {
    public long orderId;
    private List<Game> games = new ArrayList<>();
    private Card card;
    private PaymentMethod paymentMethod;
    private int installment;
    private LocalDate purchaseDate;
    private String coupon;
    private OrderStatus status;
    private long customerId;
    private long amount;

    public Order(){ }

    public Order(Card card, PaymentMethod paymentMethod, int installment, LocalDate purchaseDate, OrderStatus status){
        this.card = card;
        this.installment = installment;
        this.paymentMethod = paymentMethod;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public List<Game> getGames() {
        return this.games;
    }

    public void setGames(List<Game> games) {
        for(var game : games)
            if (!this.games.contains(game))
                    this.games.add(game);
    }

    public void setGame(Game game) {
        if (!this.games.contains(game))
                this.games.add(game);
    }

    public Card getCard() {
        return this.card;
    }

    public void setCard(Card card) {
        this.card = card;
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
