package com.haniffacateringbackend.api.service;

import com.haniffacateringbackend.api.middlewares.ResourceNotFoundException;
import com.haniffacateringbackend.api.model.Cart;
import com.haniffacateringbackend.api.model.Order;
import com.haniffacateringbackend.api.model.OrderSummary;
import com.haniffacateringbackend.api.repository.OrderSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderSummaryService {
    @Autowired
    private OrderSummaryRepository orderSummaryRepository;
    public void updateOrderSummary (OrderSummary orderSummary, Order order) {

        Map<String, Integer> counts = orderSummary.getItemCounts();
        for (Cart item : order.getItems()) {
            String name = item.getName();
            int qty = item.getQuantity();

            counts.put(name, counts.getOrDefault(name, 0) + qty);
        }
    }

    public OrderSummary getOrderSummary() {
        return orderSummaryRepository.findById("Order_Summary")
                .orElseThrow(() -> new ResourceNotFoundException("Order summary not found"));
    }
}
