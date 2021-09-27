package com.sales.online.games.salesonlinegames.Domain.Core;

public class Card {
    private String holderName;
    private String number;
    private String dueDate;
    private int cvc;

    public Card() { }

    Card(String holderName, String number, String dueDate, int cvc){
        this.holderName = holderName;
        this.number = number;
        this.dueDate = dueDate;
        this.cvc = cvc;
    }

    public String getHolderName() {
        return this.holderName;
    }

    public void setName(String name) {
        this.holderName = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String cardNumber) {
        this.number = cardNumber;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getCvc() {
        return this.cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

}
