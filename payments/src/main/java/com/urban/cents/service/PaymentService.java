package com.urban.cents.service;

import com.urban.cents.entity.Payment;
import com.urban.cents.repository.PaymentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {
        log.info("Payment creation " + payment.toString());
        return this.paymentRepository.save(payment);
    }

    public Payment updatePayment(Payment payment) {
        log.info("Payment update request " + payment.toString());
        return this.paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        this.paymentRepository.deleteById(id);
        log.info("Payment deleted");
    }

    public Payment getPayment(Long id) {
        return this.paymentRepository.findById(id).orElse(null);
    }

    public List<Payment> getPayments() {
        return this.paymentRepository.findAll();
    }

}
