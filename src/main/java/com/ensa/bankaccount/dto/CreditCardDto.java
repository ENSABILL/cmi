package com.ensa.bankaccount.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreditCardDto {
    private String cardNumber;
    private LocalDateTime creationTime;
    private LocalDateTime expirationTime;
}
