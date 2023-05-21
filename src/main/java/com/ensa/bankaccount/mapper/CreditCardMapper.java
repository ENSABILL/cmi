package com.ensa.bankaccount.mapper;

import com.ensa.bankaccount.dto.CreditCardDto;
import com.ensa.bankaccount.entity.CreditCard;
import org.springframework.beans.BeanUtils;

public class CreditCardMapper {
    public static CreditCardDto mapCreditCardToCreditCardDto(CreditCard creditCard){
        CreditCardDto creditCardDto = new CreditCardDto();
        BeanUtils.copyProperties(creditCard,creditCardDto);
        return creditCardDto;
    }
}
