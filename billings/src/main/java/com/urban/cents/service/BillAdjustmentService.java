package com.urban.cents.service;

import com.urban.cents.dtos.BillAdjustmentDTO;
import com.urban.cents.entity.Bill;
import com.urban.cents.entity.BillAdjustment;
import com.urban.cents.repository.BillAdjustmentRepository;
import com.urban.cents.repository.BillRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class BillAdjustmentService {

    private final BillAdjustmentRepository billAdjustmentRepository;
    private final BillRepository billRepository;

    @Autowired
    public BillAdjustmentService(BillAdjustmentRepository billAdjustmentAdjustmentRepository, BillRepository billRepository) {
        this.billAdjustmentRepository = billAdjustmentAdjustmentRepository;
        this.billRepository = billRepository;
    }

    public BillAdjustment createBillAdjustment(BillAdjustmentDTO billAdjustmentDTO) {

        Bill bill = this.billRepository.findById(billAdjustmentDTO.getBillId()).orElseThrow(() -> new RuntimeException("Bill not found"));
        BillAdjustment billAdjustment = BillAdjustment.from(billAdjustmentDTO);
        billAdjustment.setBill(bill);
        log.info("billAdjustment creation " + billAdjustment.toString());
        return this.billAdjustmentRepository.save(billAdjustment);
    }

    public BillAdjustment updateBillAdjustment(BillAdjustment billAdjustment) {
        log.info("billAdjustment update request " + billAdjustment.toString());
        return this.billAdjustmentRepository.save(billAdjustment);
    }

    public void deleteBillAdjustment(Long id) {
        this.billAdjustmentRepository.deleteById(id);
        log.info("billAdjustment deleted");
    }

    public BillAdjustment getBillAdjustment(Long id) {
        return this.billAdjustmentRepository.findById(id).orElse(null);
    }

    public List<BillAdjustment> getBillAdjustments() {
        return this.billAdjustmentRepository.findAll();
    }

}
