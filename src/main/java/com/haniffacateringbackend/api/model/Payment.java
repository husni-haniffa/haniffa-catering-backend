package com.haniffacateringbackend.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String id;
    private long customerPhoneNumber;
    private double amountToPay;
    private double paid = 0;
    private double balance = amountToPay;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
}
