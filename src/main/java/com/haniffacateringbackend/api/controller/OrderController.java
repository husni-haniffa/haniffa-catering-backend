package com.haniffacateringbackend.api.controller;

import com.haniffacateringbackend.api.model.Order;
import com.haniffacateringbackend.api.model.OrderSummary;
import com.haniffacateringbackend.api.service.OrderService;
import com.haniffacateringbackend.api.service.OrderSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderSummaryService orderSummaryService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/summary")
    public OrderSummary getOrderSummary() {
        return orderSummaryService.getOrderSummary();
    }
}
