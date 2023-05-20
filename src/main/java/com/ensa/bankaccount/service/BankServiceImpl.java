package com.ensa.bankaccount.service;

import com.ensa.bankaccount.dto.BankDto;
import com.ensa.bankaccount.entity.Bank;
import com.ensa.bankaccount.mapper.BankMapper;
import com.ensa.bankaccount.respository.BankRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankServiceImpl implements BankService {

    private BankRepository bankRepository;


    @Override
    public BankDto addBank(BankDto bankDto) {
        Bank bank =  bankRepository.findBankByName(bankDto.getName()).orElseThrow(() -> new RuntimeException("Bank Not Found"));
        return BankMapper.mapBanktoBankDTO(bankRepository.save(bank));
    }

    @Override
    public void deleteBankById(Long id) {
        bankRepository.deleteById(id);
    }
}
