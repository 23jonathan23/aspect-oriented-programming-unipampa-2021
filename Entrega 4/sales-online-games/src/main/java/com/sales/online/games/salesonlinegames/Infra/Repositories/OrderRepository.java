package com.sales.online.games.salesonlinegames.Infra.Repositories;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IOrderRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.Order;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.GameEntity;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.OrderEntity;

@Component
@Primary
public class OrderRepository implements IOrderRepository {

    private final SpringDataPostgresOrderRepository repository;

    public OrderRepository(final SpringDataPostgresOrderRepository repository) {
        this.repository = repository;
    }

    @Autowired
    ModelMapper modelMapper;
    
    public Order insertOrder(Order order) {
        var orderToInsert = modelMapper.map(order, OrderEntity.class);
        
        OrderEntity orderEntity = repository.save(orderToInsert);
        
        return modelMapper.map(orderEntity, Order.class);
    }

    public Order updateOrder(long orderId, Order order) {
        var orderEntity = modelMapper.map(order, OrderEntity.class);

        orderEntity.setOrderId(orderId);

        repository.save(orderEntity);
        
        return modelMapper.map(orderEntity, Order.class);
    }

    public Optional<Order> findOrderById(long orderId) {
        Optional<OrderEntity> orderEntity = repository.findById(orderId);
        
        if (orderEntity.isPresent())
            return Optional.of(modelMapper.map(orderEntity.get(), Order.class));
        else
            return Optional.empty();
    }

    public List<Order> getAll() {
        var orders = repository.findAll();

        var response = new ArrayList<Order>();

        for(var order : orders)
            response.add(modelMapper.map(order, Order.class));

        return response;
    }
}
