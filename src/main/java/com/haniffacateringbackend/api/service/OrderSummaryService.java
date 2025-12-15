package com.haniffacateringbackend.api.service;

import com.haniffacateringbackend.api.model.Cart;
import com.haniffacateringbackend.api.model.Order;
import com.haniffacateringbackend.api.model.OrderSummary;
import com.haniffacateringbackend.api.repository.OrderSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderSummaryService {
    @Autowired
    private OrderSummaryRepository orderSummaryRepository;
    public void updateOrderSummary (OrderSummary orderSummary, Order order) {
        for(Cart item : order.getItems()) {
            String name = item.getName();
            int qty = item.getQuantity();

            switch (name) {
                case "Chicken Biriyani":
                    orderSummary.setChickenBiriyani(
                            orderSummary.getChickenBiriyani() + qty
                    );
                    orderSummary.setChicken(
                            orderSummary.getChickenBiriyani() + qty
                    );
                    break;
                case "Beef Biriyani":
                    orderSummary.setBeefBiriyani(
                            orderSummary.getBeefBiriyani() + qty
                    );
                    orderSummary.setChicken(
                            orderSummary.getBeefBiriyani() + qty
                    );
                    break;
                case "Mutton Biriyani":
                    orderSummary.setMuttonBiriyani(
                            orderSummary.getMuttonBiriyani() + qty
                    );
                    orderSummary.setChicken(
                            orderSummary.getMuttonBiriyani() + qty
                    );
                    break;
                case "Ex Chicken":
                    orderSummary.setExChicken(
                            orderSummary.getExChicken() + qty
                    );
                    break;
                case "Ex Wattalapam":
                    orderSummary.setExWattalapam(
                            orderSummary.getExWattalapam() + qty
                    );
                    break;
            }
        }
    }

    public OrderSummary getOrderSummary() {
        return orderSummaryRepository.findById("GLOBAL_SUMMARY").orElseThrow();
    }
}
