package com.ensa.bankaccount.web;

import com.ensa.bankaccount.dto.AccountDto;
import com.ensa.bankaccount.request.BalanceAccountRequest;
import com.ensa.bankaccount.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountRestController {

    private AccountService accountService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<AccountDto> addAccount(@RequestBody Long customerId){
        AccountDto accountDto = accountService.addAccount(customerId);
        return new ResponseEntity<>(accountDto, HttpStatus.CREATED);
    }

    @PutMapping("/deposit")
    public ResponseEntity<Void> deposit(@RequestBody BalanceAccountRequest balanceAccountRequest) {
        accountService.deposit(balanceAccountRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/withdraw")
    public ResponseEntity<Void> withdraw(@RequestBody BalanceAccountRequest balanceAccountRequest) {
        accountService.withdraw(balanceAccountRequest);
        return ResponseEntity.ok().build();
    }



}
