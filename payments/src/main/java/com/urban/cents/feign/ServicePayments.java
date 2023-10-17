package com.urban.cents.feign;

import com.urban.cents.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("payments")
public interface ServicePayments {

    @GetMapping("/{id}")
    public Payment findById(@PathVariable Long id);

    @PostMapping
    public void createPayment(@RequestBody Payment payment);

    @PutMapping("/{id}")
    public void updatePayment(@PathVariable Long id, @RequestBody Payment payment);

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id);

    @GetMapping("/")
    public Iterable<Payment> findAll();

}
