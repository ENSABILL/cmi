package com.ensa.bankaccount.web;

import com.ensa.bankaccount.dto.CreditCardDto;
import com.ensa.bankaccount.service.CreditCardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/creditCard")
@AllArgsConstructor
public class CreditCardRestController {

    private CreditCardService creditCardService;

    @PostMapping
    public ResponseEntity<CreditCardDto> addCreditCard(@RequestBody Long accountId){
        CreditCardDto creditCardDto = creditCardService.addCreditCard(accountId);
        return new ResponseEntity<>(creditCardDto, HttpStatus.CREATED);
    }
}
