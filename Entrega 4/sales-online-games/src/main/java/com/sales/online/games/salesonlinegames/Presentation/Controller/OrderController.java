package com.sales.online.games.salesonlinegames.Presentation.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import com.sales.online.games.salesonlinegames.Domain.Application.OrderService;
import com.sales.online.games.salesonlinegames.Domain.Core.Game;
import com.sales.online.games.salesonlinegames.Domain.Core.Order;
import com.sales.online.games.salesonlinegames.Domain.Core.Report.DailySalesBody;
import com.sales.online.games.salesonlinegames.Domain.Core.Report.WeeklySalesBody;
import com.sales.online.games.salesonlinegames.Domain.Core.Request.CreateOrderRequest;

@Controller
@RequestMapping("order")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        var response = orderService.getAll();

        return new ResponseEntity<>(response ,HttpStatus.OK);
    }

    @GetMapping("/daily")
    public ResponseEntity<DailySalesBody> getDailyRelatory() {
        var report = orderService.getDailyRelatory();

        return new ResponseEntity<>(report ,HttpStatus.OK);
    }

    @GetMapping("/weekly")
    public ResponseEntity<WeeklySalesBody> getWeeklySalesRelatory() {
        var report = orderService.getWeeklySalesBody();

        return new ResponseEntity<>(report ,HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Object> getOrderById(@PathVariable long orderId) {
        var response = orderService.findById(orderId);

        return response != null
            ? new ResponseEntity<>(response ,HttpStatus.OK)
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody @Valid CreateOrderRequest request) {
        var order = new Order();
        
        BeanUtils.copyProperties(request, order);

        for(var gameId : request.getGameIds()) {
            var game = new Game();
            
            game.setGameId(gameId);

            order.setGame(game);
        }
            
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}/confirm")
    public ResponseEntity<Object> confirmOrder(@PathVariable long orderId) {
        var response = orderService.confirmOrder(orderId);

        return response != null
            ? new ResponseEntity<>(response ,HttpStatus.OK)
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");   
    }
}
