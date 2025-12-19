package com.haniffacateringbackend.api.service;

import com.haniffacateringbackend.api.middlewares.ResourceNotFoundException;
import com.haniffacateringbackend.api.model.Payment;
import com.haniffacateringbackend.api.model.PaymentStatus;
import com.haniffacateringbackend.api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(String id, double amount) {

        Payment paymentDetail = paymentRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));

        double amountToPay = paymentDetail.getAmountToPay();

        double paidAmount = paymentDetail.getPaid() + amount;

        double balance = amountToPay - paidAmount;
        paymentDetail.setPaid(paidAmount);

        paymentDetail.setBalance(balance);

        double paidSoFar = paymentDetail.getPaid();

        if (paidSoFar > 0 && paidSoFar < amountToPay) {
            paymentDetail.setPaymentStatus(PaymentStatus.PARTIAL);

        } else if (paidSoFar == amountToPay) {
            paymentDetail.setPaymentStatus(PaymentStatus.PAID);
        }

        return paymentRepository.save(paymentDetail);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll(Sort.by(Sort.Direction.DESC, "_id"));
    }
}
