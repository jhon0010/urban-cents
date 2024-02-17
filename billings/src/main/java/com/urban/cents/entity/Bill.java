package com.urban.cents.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "BILLS")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
       * Week reference to the user table, on the users service
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /**
     * Information duplicated from the user service, for internal proposes.
     */
    @Column(name="user_email")
    private String userEmail;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate billingDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private String status; // e.g., "PENDING", "PAID", "OVERDUE"

    @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BillAdjustment> billAdjustments;
}
