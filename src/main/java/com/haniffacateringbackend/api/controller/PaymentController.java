package com.haniffacateringbackend.api.controller;

import com.haniffacateringbackend.api.model.Payment;
import com.haniffacateringbackend.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Payment> updatePayment(@PathVariable String id, @RequestBody double amount) {
        Payment updatedPayment = paymentService.updatePayment(id, amount);
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    @GetMapping
    public List<Payment> getALlPayments(){
        return paymentService.getAllPayments();
    }


}
