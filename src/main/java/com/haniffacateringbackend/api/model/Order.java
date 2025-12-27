package com.haniffacateringbackend.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private String customerName;
    private long customerPhoneNumber;
    private List<Cart> items;
    private double totalAmount;
    private double advance;
    private double balance;
    private OrderStatus orderStatus = OrderStatus.PENDING;
    private OrderPaymentType orderPaymentType = OrderPaymentType.CASH;
    private OrderPaymentStatus orderPaymentStatus = OrderPaymentStatus.PENDING;
}
