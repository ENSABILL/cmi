package com.ensa.bankaccount.respository;


import com.ensa.bankaccount.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank,Long> {
    Optional<Bank> findBankByName(String name);
}
