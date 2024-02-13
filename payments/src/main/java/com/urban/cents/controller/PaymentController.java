package com.urban.cents.controller;

import com.urban.cents.entity.Payment;
import com.urban.cents.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * PaymentController
 * Showcase a simple RESTful API for Payment entity.
 */
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.paymentService.getPayment(id));
    }

    /**
     * Use the @Valid annotation to validate the request body (given the restrictions in the entity class).
     * @param payment the payment to be created
     * @return the created payment
     */
    @PostMapping
    public ResponseEntity<Payment> createPayment(@Valid @RequestBody Payment payment) {
        return ResponseEntity.ok(this.paymentService.createPayment(payment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        return ResponseEntity.ok(this.paymentService.updatePayment(payment));
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
