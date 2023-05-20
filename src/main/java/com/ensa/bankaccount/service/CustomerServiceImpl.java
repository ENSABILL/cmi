package com.ensa.bankaccount.service;

import com.ensa.bankaccount.dto.CustomerDto;
import com.ensa.bankaccount.entity.Bank;
import com.ensa.bankaccount.entity.Customer;
import com.ensa.bankaccount.mapper.BankMapper;
import com.ensa.bankaccount.mapper.CustomerMapper;
import com.ensa.bankaccount.respository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer =  customerRepository.findBankByCin(customerDto.getCin()).orElseThrow(() -> new RuntimeException("Customer Not Found"));
        return CustomerMapper.mapCustomertoCustomerDTO(customerRepository.save(customer));
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        return CustomerMapper.mapCustomertoCustomerDTO(customerRepository.findById(customerId).orElseThrow(()->new RuntimeException("Customer Not Found")));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(CustomerMapper::mapCustomertoCustomerDTO).collect(Collectors.toList());
    }
}
