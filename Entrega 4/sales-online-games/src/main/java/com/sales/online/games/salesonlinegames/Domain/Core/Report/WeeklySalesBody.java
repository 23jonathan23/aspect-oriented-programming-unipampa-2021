package com.sales.online.games.salesonlinegames.Domain.Core.Report;

import java.util.List;

import com.sales.online.games.salesonlinegames.Domain.Core.Order;
import com.sales.online.games.salesonlinegames.Domain.Core.Game;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.OrderStatus;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeeklySalesBody {

    private LocalDate date = LocalDate.now();
    
    private List<SalesQuantityPerDeveloper> perDeveloper = new ArrayList<>();
    private List<SalesQuantityPerGenre> perGenre = new ArrayList<>();
    private List<SalesQuantityPerPlatform> perPlatform = new ArrayList<>();

    public WeeklySalesBody(List<Order> orders) {
        
        for (var order : orders) {

            if (order.getStatus() == OrderStatus.FINISHED && order.getPurchaseDate().isAfter(date.minusWeeks(1))) {
                addGame(order);
            }
        }
    }

    private void addGame(Order order) {
        for (var game : order.getGames()) {
            addSalePerDeveloper(game);
            addSalePerGenre(game);
            addSalePerPlatform(game);
        }
    }

    private void addSalePerDeveloper(Game game) {
        for (var perDev : perDeveloper) {
            if (perDev.getDeveloper().equals(game.getDeveloper())) {
                perDev.addQuantity(1);
                return;
            }
        }

        if (game.getDeveloper() == null)
            return;

        perDeveloper.add(new SalesQuantityPerDeveloper(game.getDeveloper()));
    }

    private void addSalePerGenre(Game game) {
        for (var perGen : perGenre) {

            if (perGen.getGameGenre() == game.getGameGenre()) {
                perGen.addQuantity(1);
                return;
            }
        }

        if (game.getGameGenre() == null)
            return;

        perGenre.add(new SalesQuantityPerGenre(game.getGameGenre()));
    }

    private void addSalePerPlatform(Game game) {
        for (var platform : game.getPlatforms()) {
            if (platform != null)
                addPlatform(platform);
        }
    }

    private void addPlatform(Platform platform) {
        for (var perPlat : perPlatform) {
            if (perPlat.getPlatform() == platform) {
                perPlat.addQuantity(1);
                return;
            }
        }

        perPlatform.add(new SalesQuantityPerPlatform(platform));
    }

    public LocalDate getDate() {
        return date;
    }

    public List<SalesQuantityPerDeveloper> getSalesPerDeveloper() {
        return perDeveloper;
    }

    public List<SalesQuantityPerGenre> getSalesPerGenre() {
        return perGenre;
    }

    public List<SalesQuantityPerPlatform> getSalesPerPlatform() {
        return perPlatform;
    }
}
