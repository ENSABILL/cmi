package com.ensa.bankaccount.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;

//    @CreationTimestamp
    private LocalDateTime creationTime;
    private LocalDateTime expirationTime;


    private Integer cvv;

    @OneToOne
    private Account account;

    @PrePersist
    public void generate() {

        Random random1 = new Random();
        cvv = random1.nextInt(900)+100;
        
        creationTime = LocalDateTime.now();
        expirationTime = creationTime.plusYears(4);

        // Generate a random 16-digit card number
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        cardNumber = sb.toString();
    }


}
