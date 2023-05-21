package com.ensa.bankaccount.service;

import com.ensa.bankaccount.dto.CreditCardDto;

import java.util.List;

public interface CreditCardService {
    CreditCardDto addCreditCard(Long accountId);
    void deleteCreditCardById(Long id);
    CreditCardDto findByCreditCardById(Long id);

    List<CreditCardDto> findAllCreditCards();
}
