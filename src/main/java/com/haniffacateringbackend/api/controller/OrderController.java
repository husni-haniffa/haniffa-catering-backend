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

    @PutMapping("/cancelled/{id}")
    public Order cancelOrder(@PathVariable String id) {
        return orderService.cancelOrder(id);
    }

    @PutMapping("/delivered/{id}")
    public Order orderDelivered(@PathVariable String id) {
        return orderService.orderDelivered(id);
    }

    @PutMapping("/paid/{id}")
    public Order orderPaid(@PathVariable String id) {
        return orderService.orderPaid(id);
    }

    @PutMapping("/bank/{id}")
    public Order orderPaymentTypeBank(@PathVariable String id) {
        return orderService.orderPaymentTypeBank(id);
    }

    @PutMapping("/cash/{id}")
    public Order orderPaymentTypeCash(@PathVariable String id) {
        return orderService.orderPaymentTypeCash(id);
    }
}
