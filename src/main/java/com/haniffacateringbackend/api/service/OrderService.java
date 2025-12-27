package com.haniffacateringbackend.api.service;

import com.haniffacateringbackend.api.middlewares.ResourceNotFoundException;
import com.haniffacateringbackend.api.model.*;
import com.haniffacateringbackend.api.repository.ItemRepository;
import com.haniffacateringbackend.api.repository.OrderRepository;
import com.haniffacateringbackend.api.repository.OrderSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderSummaryRepository orderSummaryRepository;
    private final OrderSummaryService orderSummaryService;

    @Autowired
    public OrderService(
            OrderRepository orderRepository,
            OrderSummaryRepository orderSummaryRepository,
            OrderSummaryService orderSummaryService
    ) {
        this.orderRepository = orderRepository;
        this.orderSummaryRepository = orderSummaryRepository;
        this.orderSummaryService = orderSummaryService;
    }


    public Order createOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        OrderSummary summary = orderSummaryRepository.findById("Order_Summary")
                        .orElseGet(() -> {
                            OrderSummary orderSummary = new OrderSummary();
                            orderSummary.setId("Order_Summary");
                            return orderSummary;
                        });
        orderSummaryService.updateOrderSummary(summary, order);
        orderSummaryRepository.save(summary);
        return savedOrder;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "_id"));
    }

    public Order cancelOrder(String id) {
        Order order = orderRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        order.setOrderStatus(OrderStatus.CANCELLED);
        return orderRepository.save(order);
    }

    public Order orderDelivered(String id) {
        Order order = orderRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        order.setOrderStatus(OrderStatus.DELIVERED);
        return orderRepository.save(order);
    }

    public Order orderPaid(String id) {
        Order order = orderRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        order.setOrderPaymentStatus(OrderPaymentStatus.PAID);
        return orderRepository.save(order);

    }

    public Order orderPaymentTypeBank(String id) {
        Order order = orderRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        order.setOrderPaymentType(OrderPaymentType.BANK);
        return orderRepository.save(order);
    }

    public Order orderPaymentTypeCash(String id) {
        Order order = orderRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        order.setOrderPaymentType(OrderPaymentType.CASH);
        return orderRepository.save(order);
    }
}
