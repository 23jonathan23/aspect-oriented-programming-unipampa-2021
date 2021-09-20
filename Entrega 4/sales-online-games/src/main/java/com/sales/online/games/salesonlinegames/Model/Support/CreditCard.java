package com.sales.online.games.salesonlinegames.Model.Support;

import java.time.LocalDate;

import com.sales.online.games.salesonlinegames.Model.Customer;

public class CreditCard {
    Customer customer;
    private String name;
    private String number;
    private LocalDate validity;
    private int ccv;

    CreditCard(Customer customer, String name, String number, LocalDate validity, int ccv){
        this.customer = customer;
        this.name = name;
        this.number = number;
        this.validity = validity;
        this.ccv = ccv;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getValidity() {
        return this.validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public int getCcv() {
        return this.ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

}
