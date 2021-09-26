package com.sales.online.games.salesonlinegames.Domain.Application.Relatory;

import java.util.List;

import com.sales.online.games.salesonlinegames.Domain.Core.Game;
import com.sales.online.games.salesonlinegames.Domain.Core.Order;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;

public class DailySalesBody {
    
    private LocalDate date = LocalDate.now();
    private List<GameSales> gameSales = new ArrayList<>();

    public DailySalesBody(List<Order> orders) {

        for (var order : orders) {
            if (order.getStatus() == OrderStatus.FINISHED && order.getPurchaseDate().compareTo(date) == 0) {

                addGameSales(order);
            }
        }
    }

    private void addGameSales(Order order) {

        for (var game : order.getGames()) {

            addGame(game);
        }
    }

    private void addGame(Game game) {

        for (var sale : gameSales) {

            if (sale.getGameId() == game.getGameId()) {
                sale.addQuantity(1);
                return;
            }
        }

        gameSales.add(new GameSales(game));
    }

    public LocalDate getDate() {
        return date;
    }

    public List<GameSales> getSales() {
        return gameSales;
    }
}
