package com.example.LearnSpringProject.Service;

import com.example.LearnSpringProject.Dto.CustomerDto;
import com.example.LearnSpringProject.Entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomer();
    public CustomerDto createCustomer(CustomerDto newCustomer);
}
