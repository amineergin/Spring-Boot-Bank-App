package com.example.LearnSpringProject.Dto;

import com.example.LearnSpringProject.Entity.Account;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private Long customerid; //customer
    private Integer accType;
    private String currency; //parabirimi
    private Double accAmount;

    public static AccountDto convertFromAccountEntity(Account account){
        return AccountDto.builder()
                .customerid(account.getCustomer().getId())
                .accType(account.getAccType())
                .currency(account.getCurrency()).build();
    }
}
