package com.urban.cents.dtos;


import lombok.Data;
import java.math.BigDecimal;

@Data
public class BillAdjustmentDTO {

    private Long billId;
    private BigDecimal adjustmentAmount;
    private String reason;
}
