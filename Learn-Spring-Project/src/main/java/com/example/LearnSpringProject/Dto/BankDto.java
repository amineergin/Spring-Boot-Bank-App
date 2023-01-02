package com.example.LearnSpringProject.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankDto {
    private String banksName;
    private Double bankRate;
}
