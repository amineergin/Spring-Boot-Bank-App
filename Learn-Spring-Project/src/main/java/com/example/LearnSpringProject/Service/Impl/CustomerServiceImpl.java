package com.example.LearnSpringProject.Service.Impl;

import com.example.LearnSpringProject.Dto.AccountDto;
import com.example.LearnSpringProject.Dto.CustomerDto;
import com.example.LearnSpringProject.Entity.Account;
import com.example.LearnSpringProject.Entity.Banks;
import com.example.LearnSpringProject.Entity.Customer;
import com.example.LearnSpringProject.Repository.BanksRepository;
import com.example.LearnSpringProject.Repository.CustomerRepository;
import com.example.LearnSpringProject.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

   private final CustomerRepository customerRepository;
   private final BanksRepository banksRepository;

    @Override
    public List<Customer> getAllCustomer()
    {
        return customerRepository.findAll();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto newCustomer)
    {
        var bank = banksRepository.findById(newCustomer.getBankid()).orElseThrow(() -> new NoSuchElementException("No bank found for this id"));
        var customer = Customer.builder()
                .bank(bank)
                .custMail(newCustomer.getCustMail())
                .custName(newCustomer.getCustName())
                .custSurname(newCustomer.getCustSurname())
                .custPassword(newCustomer.getCustPassword())
                .build();
        var createdCustomer = customerRepository.save(customer);
        return CustomerDto.convertFromCustomerEntity(createdCustomer);
    }



}
