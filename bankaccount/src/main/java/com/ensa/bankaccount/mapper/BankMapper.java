package com.ensa.bankaccount.mapper;

import com.ensa.bankaccount.dto.BankDto;
import com.ensa.bankaccount.entity.Bank;
import org.springframework.beans.BeanUtils;

public class BankMapper {
    public static BankDto mapBanktoBankDTO(Bank bank){
        BankDto bankDto = new BankDto();
        BeanUtils.copyProperties(bank,bankDto);
        return bankDto;
    }
}
