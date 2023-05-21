package com.ensa.bankaccount;

import com.ensa.bankaccount.service.AccountService;
import com.ensa.bankaccount.service.CreditCardService;
import com.ensa.bankaccount.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankaccountApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(BankaccountApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
    }
}
