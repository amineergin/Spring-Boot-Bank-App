package com.example.LearnSpringProject.Controller;

import com.example.LearnSpringProject.Dto.CustomerDto;
import com.example.LearnSpringProject.Entity.Customer;
import com.example.LearnSpringProject.Service.Impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/Customers")
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @PostMapping("/createCustomer") //Müşteri oluşturma
    public CustomerDto createCustomer(@RequestBody CustomerDto newCustomer)
    {
        return customerService.createCustomer(newCustomer);
    }

}
