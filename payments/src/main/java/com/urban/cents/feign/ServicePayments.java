package com.urban.cents.feign;

import com.urban.cents.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * The org.springframework.cloud.openfeign.FeignClient annotation in the Spring Cloud OpenFeign framework is a powerful
 * tool for creating declarative REST clients in a microservices architecture.
 * By using the FeignClient annotation, you can define interfaces in your Spring application that automatically handle
 * the HTTP request construction and execution to call remote REST services.
 *
 * When used with a service discovery tool like Netflix Eureka, you can refer to services by their service ID instead of hardcoding URLs.
 * Service Discovery Integration: When used with a service discovery tool like Netflix Eureka, you can refer to services by their service ID instead of hardcoding URLs.
 * Load Balancing: Integrates with Spring Cloud LoadBalancer to provide client-side load balancing.
 * Resilience Patterns: Can be used with Spring Cloud Circuit Breaker or Netflix Hystrix for fault tolerance.
 */
@FeignClient(name="payments-services")
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
