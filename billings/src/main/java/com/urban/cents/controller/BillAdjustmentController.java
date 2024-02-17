package com.urban.cents.controller;

import com.urban.cents.dtos.BillAdjustmentDTO;
import com.urban.cents.entity.BillAdjustment;
import com.urban.cents.service.BillAdjustmentService;
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
 * billAdjustmentController
 * Showcase a simple RESTful API for billAdjustment entity.
 */
@RestController
@RequestMapping("/api/v1/bills/adjustments")
public class BillAdjustmentController {

    private final BillAdjustmentService billAdjustmentService;

    @Autowired
    public BillAdjustmentController(BillAdjustmentService billAdjustmentService) {
        this.billAdjustmentService = billAdjustmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillAdjustment> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.billAdjustmentService.getBillAdjustment(id));
    }

    /**
     * Use the @Valid annotation to validate the request body (given the restrictions in the entity class).
     * @param billAdjustmentDto the {@link BillAdjustmentDTO} to be created
     * @return the created billAdjustment
     */
    @PostMapping
    public ResponseEntity<BillAdjustment> createBillAdjustment(@Valid @RequestBody BillAdjustmentDTO billAdjustmentDto) {
        return ResponseEntity.ok(this.billAdjustmentService.createBillAdjustment(billAdjustmentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillAdjustment> updateBillAdjustment(@PathVariable Long id,@Valid  @RequestBody BillAdjustment billAdjustment) {
        return ResponseEntity.ok(this.billAdjustmentService.updateBillAdjustment(billAdjustment));
    }

    @DeleteMapping("/{id}")
    public void deleteBillAdjustment(@PathVariable Long id) {
        this.billAdjustmentService.deleteBillAdjustment(id);
    }

    @GetMapping("/")
    public Iterable<BillAdjustment> findAll() {
        return this.billAdjustmentService.getBillAdjustments();
    }

}
