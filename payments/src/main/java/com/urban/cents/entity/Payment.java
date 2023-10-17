package com.urban.cents.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Double amount;

    @Column
    private String currency;

    @Column
    private String status;
    @Column
    private String date;

    @Column
    private String description;

    @Column
    private String created_at;

    @Column()
    private String updated_at;

    @PrePersist
    public void prePersist() {
        if (this.created_at == null) {
            created_at = LocalDateTime.now().toString();
        }
    }

}
