package com.ensa.bankaccount.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder

public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float balance;

    @CreationTimestamp
    private LocalDateTime creationTime;


    @OneToOne
    private Customer customer;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
    private CreditCard creditCard;

    @PrePersist
    public void initBalance(){
        balance=0F;
    }

}
