package com.example.LearnSpringProject.Dto;

import com.example.LearnSpringProject.Entity.Account;
import com.example.LearnSpringProject.Entity.Customer;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private Long bankid;
    private double custKazanc;
    private String custName;
    private String custSurname;
    private String custMail;
    private String custPassword;

    public static CustomerDto convertFromCustomerEntity(Customer customer){
        return CustomerDto.builder()
                .bankid(customer.getId())
                .custMail(customer.getCustMail())
                .custName(customer.getCustName())
                .custSurname(customer.getCustSurname())
                .custPassword(customer.getCustPassword()).build();
    }
}
