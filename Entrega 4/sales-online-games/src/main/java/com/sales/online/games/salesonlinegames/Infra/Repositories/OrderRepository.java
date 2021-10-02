package com.sales.online.games.salesonlinegames.Infra.Repositories;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IOrderRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.Game;
import com.sales.online.games.salesonlinegames.Domain.Core.Order;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.GameEntity;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.OrderEntity;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.PlatformEntity;

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
        
        order.setOrderId(orderEntity.getOrderId());

        return order;
    }

    public Order updateOrder(long orderId, Order order) {
        var orderEntity = modelMapper.map(order, OrderEntity.class);

        orderEntity.setOrderId(orderId);

        repository.save(orderEntity);
        
        return order;
    }

    public Optional<Order> findOrderById(long orderId) {
        Optional<OrderEntity> orderEntity = repository.findById(orderId);
        
        if (orderEntity.isPresent()) {
            var order = modelMapper.map(orderEntity.get(), Order.class);

            var gamesEntity = orderEntity.get().games;

            for (int i = 0; i < gamesEntity.size(); i++) {
                order.getGames().get(i).setPlatforms(mapPlatformEntityToPlatformEnum(gamesEntity.get(i).platforms));
            }

            return Optional.of(order);
        }
        
        return Optional.empty();
    }

    public List<Order> getAll() {
        var orders = repository.findAll();

        var response = new ArrayList<Order>();

        for(var order : orders) {
            Order convertedOrder = modelMapper.map(order, Order.class);

            var games = order.games;

            List<Game> convertedGames = convertedOrder.getGames();

            for (int i = 0; i < convertedGames.size(); i++) {
                convertedGames.get(i).setPlatforms(mapPlatformEntityToPlatformEnum(games.get(i).platforms));
            }

            response.add(convertedOrder);
        }

        return response;
    }

    private List<Platform> mapPlatformEntityToPlatformEnum(List<PlatformEntity> platformsEntity) {
        var platforms = new ArrayList<Platform>();

        for(var platformEntity : platformsEntity) 
            platforms.add(Platform.values()[platformEntity.platformid.intValue()]);
        
        return platforms;
    }
}
