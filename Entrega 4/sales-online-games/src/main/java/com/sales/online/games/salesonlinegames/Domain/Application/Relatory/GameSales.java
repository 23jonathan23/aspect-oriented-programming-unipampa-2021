package com.sales.online.games.salesonlinegames.Domain.Application.Relatory;

import com.sales.online.games.salesonlinegames.Domain.Core.Game;

public class GameSales {
    
    private long gameId;
    private String name;
    private long price;
    private int quantity;
    private long total;

    public GameSales(Game game) {
        this.gameId = game.getGameId();
        this.name = game.getName();
        this.price = game.getPrice();
        quantity = 1;
        total = price;
    }

    public void addQuantity(int quantity) {
        this.quantity+= quantity;
        total = quantity * price;
    }

    public long getGameId() {
        return gameId;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getTotal() {
        return total;
    } 
}
