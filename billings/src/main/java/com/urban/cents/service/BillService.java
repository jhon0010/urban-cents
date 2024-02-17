package com.urban.cents.service;

import com.urban.cents.entity.Bill;
import com.urban.cents.repository.BillRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill createBill(Bill bill) {
        log.info("bill creation " + bill.toString());
        return this.billRepository.save(bill);
    }

    public Bill updateBill(Bill bill) {
        log.info("bill update request " + bill.toString());
        return this.billRepository.save(bill);
    }

    public void deleteBill(Long id) {
        this.billRepository.deleteById(id);
        log.info("bill deleted");
    }

    public Bill getBill(Long id) {
        return this.billRepository.findById(id).orElse(null);
    }

    public List<Bill> getBills() {
        return this.billRepository.findAll();
    }

}
