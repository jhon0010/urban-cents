package com.urban.cents.service;

import com.urban.cents.entity.Payment;
import com.urban.cents.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void createPayment(Payment payment) {
        this.paymentRepository.save(payment);
        System.out.println("Payment created");
    }

    public void updatePayment(Payment payment) {
        this.paymentRepository.save(payment);
        System.out.println("Payment updated");
    }

    public void deletePayment(Long id) {
        this.paymentRepository.deleteById(id);
        System.out.println("Payment deleted");
    }

    public Payment getPayment(Long id) {
        return this.paymentRepository.findById(id).orElse(null);
    }

    public List<Payment> getPayments() {
        return this.paymentRepository.findAll();
    }

}
