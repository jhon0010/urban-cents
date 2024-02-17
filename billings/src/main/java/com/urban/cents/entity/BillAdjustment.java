package com.urban.cents.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urban.cents.dtos.BillAdjustmentDTO;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "BILL_ADJUSTMENTS")
public class BillAdjustment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", nullable = false, insertable = false, updatable = false)
    private Bill bill;

    @Column(nullable = false)
    private BigDecimal adjustmentAmount;

    @Column(nullable = false)
    private String reason; // e.g., "DISCOUNT", "LATE_FEE"

    /**
     * Convert a BillAdjustment to a BillAdjustmentDTO
     * @param billAdjustmentDTO the billAdjustmentDTO to be converted
     * @return the converted billAdjustment
     */
    public static BillAdjustment from(BillAdjustmentDTO billAdjustmentDTO) {
        BillAdjustment billAdjustment = new BillAdjustment();
        billAdjustment.setAdjustmentAmount(billAdjustmentDTO.getAdjustmentAmount());
        billAdjustment.setReason(billAdjustmentDTO.getReason());
        return billAdjustment;
    }

}
