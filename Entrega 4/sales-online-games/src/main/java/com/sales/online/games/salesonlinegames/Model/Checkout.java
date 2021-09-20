package com.sales.online.games.salesonlinegames.Model;

import java.time.LocalDate;
import java.util.List;

import com.sales.online.games.salesonlinegames.Model.Support.CreditCard;
import com.sales.online.games.salesonlinegames.Model.Support.PaymentConditions;

public class Checkout {
    private List<Game> games;
    private CreditCard creditCard;
    private PaymentConditions paymentConditions;
    private int numberParcels;
    private LocalDate purchaseDate;
    private String discountCoupon;

    Checkout(CreditCard creditCard, PaymentConditions paymentConditions, int numberParcels, LocalDate purchaseDate){
        this.creditCard = creditCard;
        this.numberParcels = numberParcels;
        this.paymentConditions = paymentConditions;
        this.purchaseDate = purchaseDate;
    }

    public List<Game> getGames() {
        return this.games;
    }

    public boolean removeGames(Game game) {
        return games.remove(game);
    }

    public boolean addGames(Game game) {
        boolean contains = games.contains(game);

        if (contains) {
            return false;
        }

        return games.remove(game);
    }

    public CreditCard getCreditCard() {
        return this.creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public PaymentConditions getPaymentConditions() {
        return this.paymentConditions;
    }

    public void setPaymentConditions(PaymentConditions paymentConditions) {
        this.paymentConditions = paymentConditions;
    }

    public int getNumberParcels() {
        return this.numberParcels;
    }

    public void setNumberParcels(int numberParcels) {
        this.numberParcels = numberParcels;
    }

    public LocalDate getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getDiscountCoupon() {
        return this.discountCoupon;
    }

    public void setDiscountCoupon(String discountCoupon) {
        this.discountCoupon = discountCoupon;
    }

    
}
