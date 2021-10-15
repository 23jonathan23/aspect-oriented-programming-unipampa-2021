package com.sales.online.games.salesonlinegames.Domain.Application.Ports;

import com.sales.online.games.salesonlinegames.Domain.Core.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderRepository {
    Order insertOrder(Order order);

    Order updateOrder(long orderId, Order order);

    Optional<Order> findOrderById(long orderId);

    List<Order> getAll();
}
