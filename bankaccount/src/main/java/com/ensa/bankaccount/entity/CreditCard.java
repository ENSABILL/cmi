package com.ensa.bankaccount.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CreditCardNumber;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime expiryDate;

    private Integer cvv;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;


}
