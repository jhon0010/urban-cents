package com.urban.cents.controller;

import com.urban.cents.entity.Payment;
import com.urban.cents.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{id}")
    public Payment findById(@PathVariable Long id) {
        return this.paymentService.getPayment(id);
    }

    /*
    {
        "amount": 100,
        "currency": "EUR",
        "paymentMethod": "CREDIT_CARD",
        "paymentStatus": "PAID",
        "orderId": 1
    }
     */
    @PostMapping
    public void createPayment(@RequestBody Payment payment) {
        this.paymentService.createPayment(payment);
    }

    @PutMapping("/{id}")
    public void updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        this.paymentService.updatePayment(payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        this.paymentService.deletePayment(id);
    }

    @GetMapping("/")
    public Iterable<Payment> findAll() {
        return this.paymentService.getPayments();
    }

}
