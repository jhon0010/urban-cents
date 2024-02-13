package com.urban.cents.controller;

import com.urban.cents.entity.Bill;
import com.urban.cents.service.BillService;
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
 * billController
 * Showcase a simple RESTful API for bill entity.
 */
@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.billService.getBill(id));
    }

    /**
     * Use the @Valid annotation to validate the request body (given the restrictions in the entity class).
     * @param bill the bill to be created
     * @return the created bill
     */
    @PostMapping
    public ResponseEntity<Bill> createBill(@Valid @RequestBody Bill bill) {
        return ResponseEntity.ok(this.billService.createBill(bill));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long id,@Valid @RequestBody Bill bill) {
        return ResponseEntity.ok(this.billService.updateBill(bill));
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id) {
        this.billService.deleteBill(id);
    }

    @GetMapping("/")
    public Iterable<Bill> findAll() {
        return this.billService.getBills();
    }

}
