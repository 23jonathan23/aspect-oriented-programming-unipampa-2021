package com.sales.online.games.salesonlinegames.Domain.Application;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IGameRepository;
import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IOrderRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.Order;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.OrderStatus;

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

    public Order findById(long orderId) {
        Optional<Order> game = orderRepository.findOrderById(orderId);

        if(game.isPresent())
            return game.get();

        return null;
    }

    public Order createOrder(Order request) {
        request.setPurchaseDate(LocalDate.now());
        request.setStatus(OrderStatus.PROCESSING);

        for(var game : request.getGames()) {
            var gameCompleted = gameRepository.findGameById(game.getGameId());

            if(gameCompleted.isPresent()) {
                request.setAmount(request.getAmount() + gameCompleted.get().getPrice());
            }
        }

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
