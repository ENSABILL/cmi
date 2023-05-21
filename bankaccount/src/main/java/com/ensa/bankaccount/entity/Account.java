package com.ensa.bankaccount.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float Balance;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bank bank;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
    private CreditCard creditCard;

}
