package com.sales.online.games.salesonlinegames.Domain.Application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IGameRepository;
import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IOrderRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.Game;
import com.sales.online.games.salesonlinegames.Domain.Core.Order;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.OrderStatus;
import com.sales.online.games.salesonlinegames.Domain.Core.Report.DailySalesBody;
import com.sales.online.games.salesonlinegames.Domain.Core.Report.WeeklySalesBody;

public class OrderService {
    
    private final IOrderRepository orderRepository;

    private final IGameRepository gameRepository;

    public OrderService(final IOrderRepository orderRepository, final IGameRepository gameRepository) {
        this.orderRepository = orderRepository;
        this.gameRepository = gameRepository;
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public DailySalesBody getDailyRelatory() {

        return new DailySalesBody(getAll());
    }

    public WeeklySalesBody getWeeklySalesBody() {

        return new WeeklySalesBody(getAll());
    }

    public Order findById(long orderId) {
        Optional<Order> order = orderRepository.findOrderById(orderId);

        if(order.isPresent())
            return order.get();

        return null;
    }

    public Order createOrder(Order request) {
        request.setPurchaseDate(LocalDate.now());
        request.setStatus(OrderStatus.PROCESSING);
        
        var card = request.getCard();

        var sixFirstDigits = card.getNumber().substring(0, 6);

        var fourFinalDigits = card.getNumber().substring(card.getNumber().length() - 4);

        var cardWithMask = sixFirstDigits + "********" + fourFinalDigits;

        card.setNumber(cardWithMask);

        var gamesCompleted = new ArrayList<Game>();

        for(var game : request.getGames()) {
            var gameCompleted = gameRepository.findGameById(game.getGameId());

            if(gameCompleted.isPresent()) {
                request.setAmount(request.getAmount() + gameCompleted.get().getPrice());
                gamesCompleted.add(gameCompleted.get());
            }
        }

        request.setGames(gamesCompleted);

        return orderRepository.insertOrder(request);
    }

    public Order confirmOrder(long orderId) {
        Optional<Order> order = orderRepository.findOrderById(orderId);
        
        if(order.isPresent()) {
            order.get().setStatus(OrderStatus.FINISHED);
            return orderRepository.updateOrder(orderId, order.get());
        }
        
        return null;
    }
}
