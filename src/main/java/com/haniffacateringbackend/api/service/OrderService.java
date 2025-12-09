package com.haniffacateringbackend.api.service;

import com.haniffacateringbackend.api.model.Order;
import com.haniffacateringbackend.api.repository.ItemRepository;
import com.haniffacateringbackend.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "_id"));
    }
}
