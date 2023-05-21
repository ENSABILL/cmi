package com.ensa.bankaccount.service.impl;

import com.ensa.bankaccount.dto.CreditCardDto;
import com.ensa.bankaccount.entity.Account;
import com.ensa.bankaccount.entity.CreditCard;
import com.ensa.bankaccount.mapper.CreditCardMapper;
import com.ensa.bankaccount.respository.AccountRepository;
import com.ensa.bankaccount.respository.CreditCardRepository;
import com.ensa.bankaccount.service.CreditCardService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private CreditCardRepository creditCardRepository;
    private AccountRepository accountRepository;
    @Override
    public CreditCardDto addCreditCard(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account Not Found"));
        CreditCard creditCard = CreditCard.builder()
                .account(account)
                .build();
        account.setCreditCard(creditCard);
        creditCardRepository.save(creditCard);
        return CreditCardMapper.mapCreditCardToCreditCardDto(creditCard);
    }

    @Override
    public void deleteCreditCardById(Long id) {
        creditCardRepository.deleteById(id);
    }

    @Override
    public CreditCardDto findByCreditCardById(Long id) {
        return CreditCardMapper.mapCreditCardToCreditCardDto(
                creditCardRepository.findById(id).orElseThrow(()->new RuntimeException("Credit Card Not Found"))
        );
    }

    @Override
    public List<CreditCardDto> findAllCreditCards() {
        return creditCardRepository.findAll().stream().map(CreditCardMapper::mapCreditCardToCreditCardDto).collect(Collectors.toList());
    }
}
