package com.urban.cents.repository;

import com.urban.cents.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> { }
