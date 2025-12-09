package com.haniffacateringbackend.api.controller;

import com.haniffacateringbackend.api.model.Payment;
import com.haniffacateringbackend.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment createBankTransfer(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable String id, @RequestBody double amount) {
        return paymentService.updatePayment(id, amount);
    }

    @GetMapping
    public List<Payment> getALlPayments(){
        return paymentService.getAllPayments();
    }


}
