package com.ensa.bankaccount.service;

import com.ensa.bankaccount.dto.BankDto;

public interface BankService {
    BankDto addBank(BankDto bankDto);
    void deleteBankById(Long id);


}
