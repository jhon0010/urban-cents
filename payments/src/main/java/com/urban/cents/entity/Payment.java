package com.urban.cents.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * This is an entity class for Payment.
 *
 * Here we use the spring annotations to define the entity and the table, also use the lombok annotations to generates
 * boilerplate code for us, like getters and setters, toString, etc.
 *
 * Also, we use the javax validation annotations to validate the fields of the entity.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "PAYMENTS")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(value = 1, message = "Amount should be greater than 0")
    @Column
    private Double amount;

    @Column
    @NotBlank(message = "Currency is mandatory in each payment.")
    private String currency;

    @Column
    private String status;

    @PastOrPresent
    @Column
    private String date;

    @Column
    @Size(min = 1, max = 255, message = "Description should be between 1 and 255 characters")
    private String description;

    @NonNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * Automatically set the created_at field to the current date and time
     */
    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

}
